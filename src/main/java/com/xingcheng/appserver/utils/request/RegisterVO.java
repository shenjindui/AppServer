package com.xingcheng.appserver.utils.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(description = "用户注册的VO类",value = "registerVO")
@Data
public class RegisterVO {

    @ApiModelProperty(name = "username", value = "用户名",dataType = "String",required = true)
    @NotNull(message = "username不能为空")
    private String username;

    @ApiModelProperty(name = "password", value = "密码",dataType = "String",required = true)
    @Size(min = 6, max = 10, message = "密码长度应当在 6 ~ 10 个字符之间")
    @NotNull(message = "password不能为空")
    private String password;

    @ApiModelProperty(name = "email", value = "邮箱",dataType = "String",required = true)
    @Email(message = "错误的邮箱格式")
    private String email;

    @ApiModelProperty(name = "nicknames", value = "昵称",dataType = "String",required = true)
    @NotNull(message = "昵称不能为空")
    private String nicknames;
}
