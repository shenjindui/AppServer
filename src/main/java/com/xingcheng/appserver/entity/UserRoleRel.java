package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.commons.collections.MapUtils;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author : shenjindui
 * @date : 2020-01-10 22:34
 **/
@Table(name = "user_role_rel")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Builder
public class UserRoleRel  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;


    @ApiModelProperty(value = "角色编号")
    @NonNull
    @Column(name = "roleid", columnDefinition = "varchar(32) COMMENT '角色编号'")
    private String roleid;

    @ApiModelProperty(value = "用户编号")
    @NonNull
    @Column(name = "userid", columnDefinition = "varchar(32) COMMENT '用户编号'")
    private String userid;

    @ApiModelProperty(value = "是否为默认角色编号")
    @NonNull
    @Column(name = "defaultRole", columnDefinition = "varchar(1) default 0 COMMENT '是否为默认角色编号'")
    private String defaultRole;

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
        return "UserRoleRel{" +
                "uuid=" + uuid +
                ", roleid='" + roleid + '\'' +
                ", userid='" + userid + '\'' +
                ", defaultRole='" + defaultRole + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime=" + createtime +
                ", remark='" + remark + '\'' +
                '}';
    }
}

