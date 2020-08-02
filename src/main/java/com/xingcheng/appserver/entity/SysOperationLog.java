package com.xingcheng.appserver.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.collections.MapUtils;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* @类名称 SysOperationLog
* @类描述 <pre>系统操作日志表</pre>
* @作者 shenjindui
* @创建时间 2020-07-22
* @版本 V1.0
* @修改记录
*
* 版本 修改人 修改时间 修改内容描述
* ----------------------------------------------
* V1.0 shenjindui 2020-07-22 新建
* ----------------------------------------------
*
*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "operation_log")
public class SysOperationLog  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid",length = 32,columnDefinition="varchar(32) COMMENT '编号uuid'")
    private String uuid;

    @ApiModelProperty(value = "操作用户编号")
    @Column(name = "userid",columnDefinition = "varchar(32) COMMENT '操作用户编号'")
    @NonNull
    private String userid;

    @ApiModelProperty(value = "操作用户名称")
    @NonNull
    @Column(name = "username",columnDefinition = "varchar(32) COMMENT '操作用户名称'")
    private String username;

    @ApiModelProperty(value = "请求操作类名")
    @NonNull
    @Column(name = "classname",columnDefinition = "varchar(128) COMMENT '请求操作类名'")
    private String classname;

    @ApiModelProperty(value = "请求操作类名")
    @NonNull
    @Column(name = "methodname",columnDefinition = "varchar(32) COMMENT '请求操作方法名'")
    private String methodname;

    @ApiModelProperty(value = "操作用户ip")
    @NonNull
    @Column(name = "ip",columnDefinition = "varchar(32) COMMENT '操作用户ip'")
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
        return "SysOperationLog{" +
                "uuid='" + uuid + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", classname='" + classname + '\'' +
                ", methodname='" + methodname + '\'' +
                ", ip='" + ip + '\'' +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
