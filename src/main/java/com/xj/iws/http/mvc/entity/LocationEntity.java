package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 地点资料实体类
 * 标识到小区
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("LocationEntity")
public class LocationEntity {

    private int id;
    private int systemId;
    private int provinceId;
    private int cityId;
    private int areaId;
    private double positionX;
    private double positionY;
    private String name;
    private String describes;

    private SystemEntity system;
    private List<RoomEntity> room;

    private String provinceName;
    private String cityName;
    private String areaName;
    private String systemName;
    private String pic;

    public LocationEntity() {
    }

    public LocationEntity(int id, int systemId, int provinceId, int cityId, int areaId, double positionX, double positionY, String name, String describes) {
        this.id = id;
        this.systemId = systemId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.positionX = positionX;
        this.positionY = positionY;
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

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
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

    public SystemEntity getSystem() {
        return system;
    }

    public void setSystem(SystemEntity system) {
        this.system = system;
    }

    public List<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(List<RoomEntity> room) {
        this.room = room;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
