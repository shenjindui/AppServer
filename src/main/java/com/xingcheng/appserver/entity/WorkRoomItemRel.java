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

@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "workromm_item_rel")
@Builder
public class WorkRoomItemRel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "id",columnDefinition="int(32) COMMENT '编号id'")
    private int id;

    @Column(name = "workroomid",columnDefinition="varchar(32) COMMENT '工作室编号'")
    @ApiModelProperty(value = "工作室编号")
    @NonNull
    private String workroomid;

    @Column(name = "itemid",columnDefinition="varchar(32) COMMENT '项目编号'")
    @ApiModelProperty(value = "项目编号")
    @NonNull
    private String itemid;

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
        return "WorkRoomItemRel{" +
                "id=" + id +
                ", workroomid='" + workroomid + '\'' +
                ", itemid='" + itemid + '\'' +
                ", enabled='" + enabled + '\'' +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
