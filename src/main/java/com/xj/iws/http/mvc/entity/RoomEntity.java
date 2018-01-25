package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Alias("RoomEntity")
public class RoomEntity {
    private int id;
    private int locationId;
    private String name;
    private String describes;

    private LocationEntity location;
    private List<DeviceGroupEntity> deviceGroups;

    public RoomEntity() {

    }

    public RoomEntity(int id, int locationId, String name, String describes) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public List<DeviceGroupEntity> getDeviceGroups() {
        return deviceGroups;
    }

    public void setDeviceGroups(List<DeviceGroupEntity> deviceGroups) {
        this.deviceGroups = deviceGroups;
    }
}
