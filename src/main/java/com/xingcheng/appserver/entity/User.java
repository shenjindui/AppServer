package com.xingcheng.appserver.entity;

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
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
@Setter
@Getter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "id",columnDefinition="int(32) COMMENT '编号id'")
    private int id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username",columnDefinition="varchar(64) COMMENT '用户名'")
    @NonNull  private String username;

    @Column(name = "password",columnDefinition="varchar(64) COMMENT '用户密码'")
    @ApiModelProperty(value = "用户密码")
    @NonNull private String password;

    @Column(name = "nicknames",columnDefinition="varchar(32) COMMENT '昵称'")
    @ApiModelProperty(value = "昵称")
    @NonNull private String nicknames;


    @Column(name = "email",columnDefinition="varchar(32) COMMENT '用户邮箱'")
    @ApiModelProperty(value = "用户邮箱")
    @NonNull
    private String email;

    @Column(name = "phone",columnDefinition="varchar(32) COMMENT '用户电话'")
    @ApiModelProperty(value = "用户电话")
    private String phone;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @Column(name = "createtime",columnDefinition="datetime COMMENT '创建时间'")
    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    private Date createtime;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime='" + createtime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public User() {
    }

}
