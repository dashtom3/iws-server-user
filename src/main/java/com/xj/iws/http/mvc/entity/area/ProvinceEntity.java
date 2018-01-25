package com.xj.iws.http.mvc.entity.area;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Alias("ProvinceEntity")
public class ProvinceEntity {
    private int id;
    private int provinceId;
    private String name;
    private List<CityEntity> city;

    public ProvinceEntity() {
    }

    public ProvinceEntity(int id, int provinceId, String name) {
        this.id = id;
        this.provinceId = provinceId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityEntity> getCity() {
        return city;
    }

    public void setCity(List<CityEntity> city) {
        this.city = city;
    }
}
