package com.xingcheng.appserver.utils.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ApiModel(description = "忘记密码的VO类",value = "forgotVO")
@Data
public class ForgotVO {

    @ApiModelProperty(name = "username", value = "用户名",dataType = "String",required = true)
    @NotNull(message = "username不能为空")
    private String username;

    @ApiModelProperty(name = "to", value = "邮件接收者",dataType = "String",required = true)
    @NotNull(message = "邮件接收者不能为空")
    private String to;

    @ApiModelProperty(name = "subject", value = "主题",dataType = "String")
    //@NotNull(message = "主题")
    private String subject;

}
