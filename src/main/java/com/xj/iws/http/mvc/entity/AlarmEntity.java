package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Alias("AlarmEntity")
public class AlarmEntity {
    private int id;
    private int systemId;
    private int locationId;
    private int roomId;
    private int groupId;
    private Date startTime;
    private Date endTime;
    private int status;
    private int confirm;
    private String name;
    private String describes;

    private String systemName;
    private String locationName;
    private String groupName;
    private String roomName;

    private List<DataEntity> data;

    public AlarmEntity() {
    }

    public AlarmEntity(int id, int systemId, int locationId, int roomId, int groupId, Date startTime, Date endTime, int status, int confirm, String name, String describes) {
        this.id = id;
        this.systemId = systemId;
        this.locationId = locationId;
        this.roomId = roomId;
        this.groupId = groupId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.confirm = confirm;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }
}
