package com.xj.iws.http.mvc.entity;

/**
 * Created by Administrator on 2017/12/14.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *保养表
 */
public class Maintenance {
    private Integer maintenanceId;
    private UserEntity userEntity;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date previousTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nextTime;
    private SystemE system;
    private Location location;
    private Long period;

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPreviousTime() {
        return previousTime;
    }

    public void setPreviousTime(Date previousTime) {
        this.previousTime = previousTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
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

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Maintenance() {
    }

    public Maintenance(Integer maintenanceId, UserEntity userEntity, Date previousTime, Date nextTime, SystemE system, Location location, Long period) {
        this.maintenanceId = maintenanceId;
        this.userEntity = userEntity;
        this.previousTime = previousTime;
        this.nextTime = nextTime;
        this.system = system;
        this.location = location;
        this.period = period;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", userEntity=" + userEntity +
                ", previousTime=" + previousTime +
                ", nextTime=" + nextTime +
                ", system=" + system +
                ", location=" + location +
                ", period=" + period +
                '}';
    }
}
