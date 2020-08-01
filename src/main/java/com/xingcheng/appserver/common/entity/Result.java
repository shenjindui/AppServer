package com.xingcheng.appserver.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回对象
 */

@Data
public class Result<T> implements Serializable {
    /**
     * 通信数据
     */
    private T data;
    /**
     * 通信状态
     */
    private int status = 200;
    /**
     * 通信描述
     */
    private String description = "操作成功";

    /**
     * 通过静态方法获取实例
     */
    public static <T> Result<T> of(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> of(T data, int flag) {
        return new Result<>(data, flag);
    }

    public static <T> Result<T> of(T data, int flag, String msg) {
        return new Result<>(data, flag, msg);
    }

    @Deprecated
    public Result() {

    }

    private Result(T data) {
        this.data = data;
    }

    private Result(T data, int status) {
        this.data = data;
        this.status = status;
    }

    private Result(T data, int status, String description) {
        this.data = data;
        this.status = status;
        this.description = description;
    }

}
