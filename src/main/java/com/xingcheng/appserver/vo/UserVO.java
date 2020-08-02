package com.xingcheng.appserver.vo;

import com.xingcheng.appserver.common.entity.PageCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shenjindui
 * @create 2020-07-15 13:31
 **/
@Data
public class UserVO extends PageCondition implements Serializable {

    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
     private String password;

    @ApiModelProperty(value = "昵称")
    private String nicknames;


    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @ApiModelProperty(value = "用户信誉")
    private String usercredit;

    @ApiModelProperty(value = "用户电话")
    private String phone;

    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "备注")
    private String remark;



}
