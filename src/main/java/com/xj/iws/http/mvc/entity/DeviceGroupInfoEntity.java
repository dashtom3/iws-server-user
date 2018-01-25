package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/29.
 */
@Alias("DeviceGroupInfoEntity")
public class DeviceGroupInfoEntity {
    private int id;
    private String terms;
    private int status;
    private int type;
    private String name;
    private String describes;

    List<DeviceGroupTypeEntity> groupType;
    List<DeviceTermEntity> deviceTerms;
    List<DeviceEntity> devices;

    public DeviceGroupInfoEntity() {
    }

    public DeviceGroupInfoEntity(int id, String terms, int status, int type, String name, String describes) {
        this.id = id;
        this.terms = terms;
        this.status = status;
        this.type = type;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<DeviceGroupTypeEntity> getGroupType() {
        return groupType;
    }

    public void setGroupType(List<DeviceGroupTypeEntity> groupType) {
        this.groupType = groupType;
    }

    public List<DeviceTermEntity> getDeviceTerms() {
        return deviceTerms;
    }

    public void setDeviceTerms(List<DeviceTermEntity> deviceTerms) {
        this.deviceTerms = deviceTerms;
    }

    public List<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceEntity> devices) {
        this.devices = devices;
    }
}
