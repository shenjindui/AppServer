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

@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "message")
@Builder
public class Message implements Serializable {

    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @Column(name = "workroomid",columnDefinition="varchar(32) COMMENT '留言工作室编号'")
    @ApiModelProperty(value = "留言工作室编号")
    @NonNull
    private String workroomid;

    @Column(name = "messagedetail",columnDefinition="varchar(32) COMMENT '留言内容'")
    @ApiModelProperty(value = "留言内容")
    @NonNull
    private String messagedetail;

    @Column(name = "enabled",columnDefinition = "varchar(1) default '1' COMMENT '是否有效'")
    @ApiModelProperty(value = "是否有效")
    private String enabled;

    @Column(name = "userid",columnDefinition="varchar(32) COMMENT '用户编号'")
    @ApiModelProperty(value = "用户编号")
    @NonNull
    private String userid;

    @CreatedDate
    @Column(name = "createtime",columnDefinition="datetime COMMENT '创建时间'")
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @Column(name = " readed",columnDefinition = "varchar(1) default '1' COMMENT '是否已读'")
    @ApiModelProperty(value = "是否已读")
    private String readed;

    @Override
    public String toString() {
        return "Message{" +
                "uuid=" + uuid +
                ", workroomid='" + workroomid + '\'' +
                ", messagedetail='" + messagedetail + '\'' +
                ", enabled='" + enabled + '\'' +
                ", userid='" + userid + '\'' +
                ", createtime=" + createtime +
                ", readed='" + readed + '\'' +
                '}';
    }
}
