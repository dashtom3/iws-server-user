package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by XiaoJiang01 on 2017/4/26.
 */
@Alias("LogEntity")
public class LogEntity {
    private int id;
    private int userId;
    private int type;
    private Date time;
    private String describes;
    private String errorCode;
    private String ip;

    private String userName;

    public LogEntity() {
    }

    public LogEntity(int userId, String describes, String ip) {
        this.userId = userId;
        this.describes = describes;
        this.ip = ip;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
