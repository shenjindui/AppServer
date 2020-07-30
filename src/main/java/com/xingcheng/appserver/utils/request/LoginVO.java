package com.xingcheng.appserver.utils.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "用户登陆的VO类",value = "loginVO")
@Data
public class LoginVO {

    @ApiModelProperty(name = "username", value = "用户名",dataType = "String",required = true)
    private String username;

    @ApiModelProperty(name = "password", value = "密码",dataType = "String",required = true)
    private String password;
}
