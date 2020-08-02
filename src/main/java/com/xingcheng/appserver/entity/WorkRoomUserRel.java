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

/**
 * 用户工作室关系表
 */
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "workromm_user_rel")
@Builder
public class WorkRoomUserRel implements Serializable {

    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @Column(name = "workroomid",columnDefinition="varchar(32) COMMENT '工作室编号'")
    @ApiModelProperty(value = "工作室编号")
    @NonNull
    private String workroomid;

    @Column(name = "userid",columnDefinition="varchar(32) COMMENT '用户编号'")
    @ApiModelProperty(value = "用户编号")
    @NonNull
    private String userid;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '创建时间'")
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @Override
    public String toString() {
        return "WorkrommUserRel{" +
                "uuid=" + uuid +
                ", workroomid='" + workroomid + '\'' +
                ", userid='" + userid + '\'' +
                ", enabled='" + enabled + '\'' +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
