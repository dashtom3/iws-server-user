package com.xj.iws.http.mvc.entity.util;

import com.xj.iws.common.enums.DataEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/18.
 */
public class ViewDataEntity {
    private String port;
    private String number;
    private Date time;
    private DataEnum exception;
    private int count;
    private String addressName;
    private String locationName;
    private String roomName;
    private String groupName;
    private List<DataField> data;

    public ViewDataEntity() {
    }

    public ViewDataEntity(String port, String number, Date time, DataEnum exception, int count, String addressName, String locationName, String roomName, String groupName, List<DataField> data) {
        this.port = port;
        this.number = number;
        this.time = time;
        this.exception = exception;
        this.count = count;
        this.addressName = addressName;
        this.locationName = locationName;
        this.roomName = roomName;
        this.groupName = groupName;
        this.data = data;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public DataEnum getException() {
        return exception;
    }

    public void setException(DataEnum exception) {
        this.exception = exception;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<DataField> getData() {
        return data;
    }

    public void setData(List<DataField> data) {
        this.data = data;
    }
}
