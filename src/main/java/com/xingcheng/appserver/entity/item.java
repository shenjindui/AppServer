package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目表
 */
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "item")
@Builder
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "id",columnDefinition="int(32) COMMENT '编号id'")
    private int id;

    @Column(name = "itemname",columnDefinition="varchar(32) COMMENT '项目名称'")
    @ApiModelProperty(value = "项目名称")
    @NonNull
    private String itemname;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '项目创建时间'")
    @ApiModelProperty(value = "项目创建时间")
    private Date createtime;

    @Column(name = "itemicons",columnDefinition="varchar(128) COMMENT '项目图标'")
    @ApiModelProperty(value = "项目图标")
    private String itemicons;

    @Column(name = "itemdetail",columnDefinition="varchar(256) COMMENT '项目内容（详情）'")
    @ApiModelProperty(value = "项目内容（详情）")
    private String itemdetail;

    @Column(name = "itemprogress",columnDefinition="varchar(64) COMMENT '项目进度'")
    @ApiModelProperty(value = "项目进度")
    private String itemprogress;

    @Column(name = "itemdone",columnDefinition="varchar(1) default '1' COMMENT '项目是否完成'")
    @ApiModelProperty(value = "项目是否完成")
    private String itemdone;

    @Column(name = "itemdifficulty",columnDefinition="varchar(32)  COMMENT '项目难度'")
    @ApiModelProperty(value = "项目难度")
    private String itemdifficulty;

    @Column(name = "itemconstructionperiod",columnDefinition="varchar(32)  COMMENT '项目工期（单位天）'")
    @ApiModelProperty(value = "项目工期")
    private String itemconstructionperiod;

    @Column(name = "itemcredit",columnDefinition="varchar(32) COMMENT '项目信誉（百分制）'")
    @ApiModelProperty(value = "项目信誉")
    private String itemcredit;

    @Column(name = "itemchargeid",columnDefinition="varchar(32) COMMENT '项目负责人编号'")
    @ApiModelProperty(value = "项目负责人编号")
    private String itemchargeid;

    @Column(name = "remark",columnDefinition="varchar(128) COMMENT '备注'")
    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemname='" + itemname + '\'' +
                ", enabled='" + enabled + '\'' +
                ", createtime=" + createtime +
                ", itemicons='" + itemicons + '\'' +
                ", itemdetail='" + itemdetail + '\'' +
                ", itemprogress='" + itemprogress + '\'' +
                ", itemdone='" + itemdone + '\'' +
                ", itemdifficulty='" + itemdifficulty + '\'' +
                ", itemconstructionperiod='" + itemconstructionperiod + '\'' +
                ", itemcredit='" + itemcredit + '\'' +
                ", itemchargeid='" + itemchargeid + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
