package com.xingcheng.appserver.controller;

import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IUserService;
import com.xingcheng.appserver.utils.constant.SysConstant;
import com.xingcheng.appserver.utils.request.LoginVO;
import com.xingcheng.appserver.utils.request.RegisterVO;
import com.xingcheng.appserver.utils.response.BaseAppAction;
import com.xingcheng.appserver.utils.response.ResponseVO;
import com.xingcheng.appserver.utils.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author shenjindui
 * @create 2020-07-15 13:31
 **/

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
@Api(description = "用户信息管理")
public class UserController extends BaseAppAction {

    protected final static Logger logger = LoggerFactory.getLogger(BaseAppAction.class);

    @Autowired
    IUserService userService;

    @ApiOperation(value = "登陆操作", notes = "根据账号密码获取用户详细信息")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVO login(@ApiParam(value = "请输入账号密码",required = true) @Validated LoginVO loginVO) {
        User user = userService.findByUsernameAndPassword(MD5Utils.convertMD5(loginVO.getUsername()),
                MD5Utils.convertMD5(loginVO.getPassword()));
        if(user!=null){
            return successResponse(user, SysConstant.LOGIN_SUCCESS);
        }
        return errorResponse(SysConstant.LOGIN_ERROR);
    }

    @ApiOperation(value = "注册操作", notes = "用户详注册的详细信息")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVO register(@ApiParam(value = "请输入注册信息",required = true) @Validated RegisterVO registerVO) {
        User user = userService.save(User.of(MD5Utils.stringToMD5(registerVO.getUsername()),
                MD5Utils.stringToMD5(registerVO.getPassword()),registerVO.getEmail()).setEnabled(SysConstant.ENABLE));
        if(user!=null){
            return successResponse(user, SysConstant.SAVE_SUCCESS);
        }
        return errorResponse(SysConstant.SAVE_ERROR);
    }
}
