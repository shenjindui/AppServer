package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "login_log")
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @ApiModelProperty(value = "用户编号")
    @Column(name = "userid",columnDefinition = "varchar(32) COMMENT '用户编号'")
    @NonNull
    private String userid;

    @ApiModelProperty(value = "用户名称")
    @NonNull
    @Column(name = "username",columnDefinition = "varchar(32) COMMENT '用户名称'")
    private String username;

    @ApiModelProperty(value = "mac地址")
    @NonNull
    @Column(name = "mac",columnDefinition = "varchar(128) COMMENT 'mac地址'")
    private String mac;


    @ApiModelProperty(value = "用户ip")
    @NonNull
    @Column(name = "ip",columnDefinition = "varchar(32) COMMENT '用户ip'")
    private String ip;

    @ApiModelProperty(value = "备注")
    @NonNull
    @Column(name = "remark",columnDefinition = "varchar(255) COMMENT '备注'")
    private String remark;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '创建时间'")
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @Override
    public String toString() {
        return "SysLoginLog{" +
                "uuid='" + uuid + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
