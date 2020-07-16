package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "role")
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "id",columnDefinition="int(32) COMMENT '编号id'")
    private int id;

    @Column(name = "rolename",columnDefinition="varchar(32) COMMENT '角色名'")
    @ApiModelProperty(value = "角色名")
    @NonNull
    private String rolename;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '角色创建时间'")
    @ApiModelProperty(value = "角色创建时间")
    private Date createtime;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime='" + createtime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
//建造者模式创建Role role = Role.builder().rolename("admin").build();


}
