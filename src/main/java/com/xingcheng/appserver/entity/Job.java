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
 * 任务表
 */
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "job")
@Builder
public class Job implements Serializable {

    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @Column(name = "jobname",columnDefinition="varchar(32) COMMENT '项目名称'")
    @ApiModelProperty(value = "任务名称")
    @NonNull
    private String jobname;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '项目创建时间'")
    @ApiModelProperty(value = "项目创建时间")
    private Date createtime;

    @Column(name = "jobicons",columnDefinition="varchar(128) COMMENT '任务图标'")
    @ApiModelProperty(value = "任务图标")
    private String jobicons;

    @Column(name = "jobdetail",columnDefinition="varchar(256) COMMENT '任务内容（详情）'")
    @ApiModelProperty(value = "任务内容（详情）")
    private String jobdetail;

    @Column(name = "jobprogress",columnDefinition="varchar(64) COMMENT '任务进度'")
    @ApiModelProperty(value = "任务进度")
    private String jobprogress;

    @Column(name = "jobdone",columnDefinition="varchar(1) default '1' COMMENT '任务是否完成'")
    @ApiModelProperty(value = "任务是否完成")
    private String jobdone;

    @Column(name = "jobdifficulty",columnDefinition="varchar(32)  COMMENT '任务难度'")
    @ApiModelProperty(value = "任务难度")
    private String jobdifficulty;

    @Column(name = "jobconstructionperiod",columnDefinition="varchar(32)  COMMENT '任务工期（单位天）'")
    @ApiModelProperty(value = "任务工期")
    private String jobconstructionperiod;

    @Column(name = "jobcredit",columnDefinition="varchar(32) COMMENT '任务信誉（百分制）'")
    @ApiModelProperty(value = "任务信誉")
    private String jobcredit;

    @Column(name = "jobchargeid",columnDefinition="varchar(32) COMMENT '任务负责人编号'")
    @ApiModelProperty(value = "任务负责人编号")
    private String jobchargeid;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "Job{" +
                "uuid=" + uuid +
                ", jobname='" + jobname + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime=" + createtime +
                ", jobicons='" + jobicons + '\'' +
                ", jobdetail='" + jobdetail + '\'' +
                ", jobprogress='" + jobprogress + '\'' +
                ", jobdone='" + jobdone + '\'' +
                ", jobdifficulty='" + jobdifficulty + '\'' +
                ", jobconstructionperiod='" + jobconstructionperiod + '\'' +
                ", jobcredit='" + jobcredit + '\'' +
                ", jobchargeid='" + jobchargeid + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
