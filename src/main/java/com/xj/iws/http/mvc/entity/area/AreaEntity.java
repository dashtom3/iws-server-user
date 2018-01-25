package com.xj.iws.http.mvc.entity.area;

import com.xj.iws.http.mvc.entity.LocationEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Alias("AreaEntity")
public class AreaEntity {
    private int id;
    private int areaId;
    private String name;
    private int cityId;

    private String cityName;
    private String provinceName;

    private CityEntity city;
    private List<LocationEntity> location;

    public AreaEntity() {
    }

    public AreaEntity(int id, int areaId, String name, int cityId) {
        this.id = id;
        this.areaId = areaId;
        this.name = name;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<LocationEntity> getLocation() {
        return location;
    }

    public void setLocation(List<LocationEntity> location) {
        this.location = location;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
