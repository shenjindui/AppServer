package com.xingcheng.appserver.controller;

import com.xingcheng.appserver.common.controller.CommonController;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sysUser1/")
@Api(description = "用户信息管理Test")
public class SysUserController1 extends CommonController<User, User, Integer> {
    @Autowired
    private IUserService userService;

    /*@ApiOperation(value = "登陆操作", notes = "根据账号密码获取用户详细信息")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Result<User> login(@ApiParam(value = "请输入账号密码",required = true) @Validated LoginVO loginVO) {
        return super.get(1);
    }
*/

}
