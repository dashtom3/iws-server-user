package com.xj.iws.http.mvc.entity.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xj.iws.http.mvc.entity.Location;
import com.xj.iws.http.mvc.entity.SystemE;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by 小月亮 on 2017/12/11.
 */
public class DataSave {
    private Integer status;//地点
    private Integer userId;
    private String problems;//问题点
    private String teamwork;//协调工作
    private String detailMsg;//详情
    private String img;//图片
    private Double lng;//经度
    private Double lat;//纬度
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;//时间
    private String name;//系统
    private String msg;//描述
    private String startTime;
    private String endTime;
    private String address;//详细地址
    private String userName;//人员名称
    private SystemE system;
    private Location location;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public String getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(String teamwork) {
        this.teamwork = teamwork;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SystemE getSystem() {
        return system;
    }

    public void setSystem(SystemE system) {
        this.system = system;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DataSave() {
    }

    public DataSave(Integer status, Integer userId, String problems, String teamwork, String detailMsg, String img, Double lng, Double lat, Date time, String name, String msg, String startTime, String endTime, String address, String userName, SystemE system, Location location) {
        this.status = status;
        this.userId = userId;
        this.problems = problems;
        this.teamwork = teamwork;
        this.detailMsg = detailMsg;
        this.img = img;
        this.lng = lng;
        this.lat = lat;
        this.time = time;
        this.name = name;
        this.msg = msg;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.userName = userName;
        this.system = system;
        this.location = location;
    }

    @Override
    public String toString() {
        return "DataSave{" +
                "status=" + status +
                ", userId=" + userId +
                ", problems='" + problems + '\'' +
                ", teamwork='" + teamwork + '\'' +
                ", detailMsg='" + detailMsg + '\'' +
                ", img='" + img + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", systemE=" + system +
                ", location=" + location +
                '}';
    }
}
