package com.xingcheng.appserver.utils.response;

/**
 * @author : shenjindui
 * @date : 2020-07-15 13:31
 **/
public class ResponseVO {
    public static final int OK = 200;
    public static final int ERROR = 100;
    public static final int NO_LOGIN = 101;
    public static final int WARN = 300;

    private int status;
    private String description;
    private Object data;

    public ResponseVO() {
    }

    public ResponseVO(int status, String description, Object data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public ResponseVO(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
