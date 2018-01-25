package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceEntity")
public class DeviceEntity {
    private int id;
    private int groupId;
    private int termId;
    private int status;
    private String port;
    private String number;
    private String name;
    private String describes;

    private DeviceTermEntity deviceTerm;

    private String termName;
    private String termType;
    private int count;
    private int bit;
    private String protocol;

    public DeviceEntity() {
    }

    public DeviceEntity(int id, int groupId, int termId, int status, String port, String number, String name, String describes) {
        this.id = id;
        this.groupId = groupId;
        this.termId = termId;
        this.status = status;
        this.port = port;
        this.number = number;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public DeviceTermEntity getDeviceTerm() {
        return deviceTerm;
    }

    public void setDeviceTerm(DeviceTermEntity deviceTerm) {
        this.deviceTerm = deviceTerm;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", termId=" + termId +
                ", status=" + status +
                ", port='" + port + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", deviceTerm=" + deviceTerm +
                ", termName='" + termName + '\'' +
                ", termType='" + termType + '\'' +
                ", count=" + count +
                ", bit=" + bit +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
