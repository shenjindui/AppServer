package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_setting")
@Data
public class SysSetting implements Serializable {
    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @Column(name = "sysname",columnDefinition="varchar(32) COMMENT '系统名称'")
    @ApiModelProperty(value = "系统名称")
    private String sysname;//系统名称

    @Column(name = "syslogo",columnDefinition="varchar(256) COMMENT '系统logo图标'")
    @ApiModelProperty(value = "系统logo图标")
    private String syslogo;//系统logo图标

    @Column(name = "sysbottomtext",columnDefinition="varchar(128) COMMENT '系统底部信息'")
    @ApiModelProperty(value = "系统底部信息")
    private String sysbottomtext;//系统底部信息

    @Column(name = "syscolor",columnDefinition="varchar(32) COMMENT '系统颜色'")
    @ApiModelProperty(value = "系统颜色")
    private String syscolor;//系统颜色

    @Column(name = "sysnoticetext",columnDefinition="text COMMENT '系统公告'")
    @ApiModelProperty(value = "系统公告")
    private String sysnoticetext;//系统公告

    @Column(name = "sysapiencrypt",columnDefinition="varchar(1) COMMENT 'API加密 Y/N'")
    @ApiModelProperty(value = "API加密 Y/N")
    private String sysapiencrypt;//API加密 Y/N

    @Column(name = "createtime",columnDefinition="datetime COMMENT '创建时间'")
    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    private Date createtime;

    @Column(name = "userinitpassword",columnDefinition="varchar(64) COMMENT '用户管理：初始、重置密码'")
    @ApiModelProperty(value = "用户管理：初始、重置密码")
    private String userinitpassword;//用户管理：初始、重置密码

    @Override
    public String toString() {
        return "SysSetting{" +
                "uuid=" + uuid +
                ", sysname='" + sysname + '\'' +
                ", syslogo='" + syslogo + '\'' +
                ", sysbottomtext='" + sysbottomtext + '\'' +
                ", syscolor='" + syscolor + '\'' +
                ", sysnoticetext='" + sysnoticetext + '\'' +
                ", sysapiencrypt='" + sysapiencrypt + '\'' +
                ", createtime=" + createtime +
                ", userinitpassword='" + userinitpassword + '\'' +
                '}';
    }

    public SysSetting() {
    }
}
