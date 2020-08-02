package com.xingcheng.appserver.controller;

import com.xingcheng.appserver.common.controller.CommonController;
import com.xingcheng.appserver.common.entity.Result;
import com.xingcheng.appserver.entity.User;
import com.xingcheng.appserver.service.IMailService;
import com.xingcheng.appserver.service.IUserService;
import com.xingcheng.appserver.utils.constant.SysConstant;
import com.xingcheng.appserver.utils.request.ForgotVO;
import com.xingcheng.appserver.utils.request.LoginVO;
import com.xingcheng.appserver.utils.response.BaseAppAction;
import com.xingcheng.appserver.utils.response.ResponseVO;
import com.xingcheng.appserver.utils.util.JwtTokenUtils;
import com.xingcheng.appserver.utils.util.RandomUtils;
import com.xingcheng.appserver.utils.util.RedisUtils;
import com.xingcheng.appserver.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author shenjindui
 * @create 2020-07-15 13:31
}*/

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
@Api(description = "用户信息管理")
public class UserController extends CommonController<UserVO, User, String> {

    protected final static Logger logger = LoggerFactory.getLogger(BaseAppAction.class);

    private final JwtTokenUtils jwtTokenUtils;

    public UserController(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IUserService userService;

    @Autowired
    private IMailService mailService;

    @ApiOperation(value = "登陆操作", notes = "根据账号密码获取用户详细信息")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@ApiParam(value = "请输入账号密码",required = true) @Validated LoginVO loginVO) {
        User user = userService.findByUsernameAndPassword(((loginVO.getUsername().trim())),
                ((loginVO.getPassword().trim())));
        if(user==null){
            return Result.of(SysConstant.LOGIN_ERROR);
        }
        String token = jwtTokenUtils.createToken(String.valueOf(user.getUuid()),user.getUsername());
        Map<String,Object> map = new HashMap();
        map.clear();
        map.put("user",user);
        map.put("token",token);
        return Result.of(map,200,SysConstant.LOGIN_SUCCESS);
    }

   /* @ApiOperation(value = "注册操作", notes = "用户详注册的详细信息")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@ApiParam(value = "请输入注册信息",required = true) @Validated RegisterVO registerVO){
        User user = userService.save(User.of((registerVO.getUsername()),
        (registerVO.getPassword()),registerVO.getNicknames(),registerVO.getEmail()).setEnabled(SysConstant.ENABLE));
        if(user!=null){
            return Result.of(user,200,SysConstant.LOGIN_SUCCESS);;
        }
        return Result.of(SysConstant.REGISTER_ERROR);
    }*/

    //@TokenCheck  token值检验（暂未启用）
    //@Limiter(frequency = 10) 接口防刷 （暂未启用）
    /*@ApiOperation(value = "获取用户个人详细信息", notes = "获取用户个人详细信息")
    @RequestMapping(value = "/getUserDetail", method = RequestMethod.POST)
    public Result getUserDetail(@ApiParam(value = "请输入账号id",required = true) @NonNull @RequestParam int  id) {
        User user = userService.findById(id);
        if(user!=null){
            return successResponse(user, SysConstant.GET_SUCCESS);
        }
        return errorResponse(SysConstant.GET_ERROR);
    }*/

    @ApiOperation(value = "忘记密码，重置密码，检验邮箱系统存在", notes = "忘记密码重置密码检验邮箱系统存在")
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public Result forgotPassword(@ApiParam(value = "请输入邮箱账号信息",required = true) @Email(message = "请输入正确的邮箱") @RequestParam String  email){
        List<User> users = userService.findByEmail(email);
        if(users==null || users.isEmpty() || users.size() < 1){
            return Result.of("系统不存在该账号："+email);
        }
        return Result.of("忘记密码邮箱检验正确！");
    }

    @ApiOperation(value = "忘记密码发送邮件方法，目前使用QQ邮箱", notes = "忘记密码发送邮件方法目前使用QQ邮箱", httpMethod = "POST")
    @RequestMapping(value = "/forgetSendMail", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result forgetSendMail(@ApiParam(value = "请提供对应的信息",required = true) @Validated ForgotVO forgotVO) {
        try {
            Map<String,Object> parms=new HashMap<>();
            String code= RandomUtils.stringWithNumber(6);
            String context = "欢迎使用星辰远征APP,您的验证码是:<a>"+code+"</a>,本验证码60秒内有效!";
            parms.put("content",context);
            String to= forgotVO.getTo();//发送给谁
            String subject=(forgotVO.getSubject().equals(null)||forgotVO.getSubject().equals(""))?"来自星辰远征APP的安全验证邮件":forgotVO.getSubject();//主题
            String content=context;//内容
            mailService.sendHtmlMail(to,subject,content);
            //redisUtils.set(forgotVO.getUsername(),code,60); 暂时不使用redis
            return Result.of(SysConstant.SEND_SUCCESS+"发送成功,请及时查收验证码!");
        } catch (Exception e) {
            return Result.of(e.getMessage());
        }
    }

}
