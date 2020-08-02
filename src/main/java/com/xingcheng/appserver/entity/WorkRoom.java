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
 * 工作室表
 */
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "workroom")
@Builder
public class WorkRoom implements Serializable {
    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @Column(name = "workroomname",columnDefinition="varchar(32) COMMENT '工作室名称'")
    @ApiModelProperty(value = "工作室名称")
    @NonNull
    private String workroomname;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '工作室创建时间'")
    @ApiModelProperty(value = "工作室创建时间")
    private Date createtime;

    @Column(name = "workroomicons",columnDefinition="varchar(128) COMMENT '工作室图标'")
    @ApiModelProperty(value = "工作室图标")
    private String workroomicons;

    @Column(name = "workroomdetail",columnDefinition="varchar(256) COMMENT '工作室简介'")
    @ApiModelProperty(value = "工作室简介")
    private String workroomdetail;

    @Column(name = "workroomcredit",columnDefinition="varchar(32) COMMENT '工作室信誉（百分制）'")
    @ApiModelProperty(value = "工作室信誉")
    private String workroomcredit;

    @Column(name = "workroomchargeid",columnDefinition="varchar(32) COMMENT '工作室负责人编号'")
    @ApiModelProperty(value = "工作室负责人编号")
    private String workroomchargeid;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "WorkRoom{" +
                "uuid=" + uuid +
                ", workroomname='" + workroomname + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime=" + createtime +
                ", workroomicons='" + workroomicons + '\'' +
                ", workroomdetail='" + workroomdetail + '\'' +
                ", workroomcredit='" + workroomcredit + '\'' +
                ", workroomchargeid='" + workroomchargeid + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
