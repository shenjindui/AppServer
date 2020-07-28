package com.xingcheng.appserver.utils.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterVO {

    @NotNull(message = "username不能为空")
    private String username;

    @Size(min = 6, max = 10, message = "密码长度应当在 6 ~ 10 个字符之间")
    @NotNull(message = "password不能为空")
    private String password;

    @Email(message = "错误的邮箱格式")
    private String email;

    @NotNull(message = "nicknames不能为空")
    private String nicknames;
}
