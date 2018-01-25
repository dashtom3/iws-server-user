package com.xj.iws.http.mvc.entity.area;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Alias("CityEntity")
public class CityEntity {
    private int id;
    private int cityId;
    private String name;
    private int provinceId;
    private ProvinceEntity province;
    private List<AreaEntity> area;

    public CityEntity() {
    }

    public CityEntity(int id, int cityId, String name, int provinceId) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public List<AreaEntity> getArea() {
        return area;
    }

    public void setArea(List<AreaEntity> area) {
        this.area = area;
    }
}
