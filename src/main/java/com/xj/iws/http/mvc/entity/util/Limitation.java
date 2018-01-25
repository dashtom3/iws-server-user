package com.xj.iws.http.mvc.entity.util;

/**
 * Created by XiaoJiang01 on 2017/4/20.
 */
public class Limitation {
    private int systemId;
    private String provinceId;
    private String cityId;
    private String areaId;
    private int limit;

    public Limitation() {
    }

    public Limitation(int systemId, String provinceId, String cityId, String areaId, int limit) {
        this.systemId = systemId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.limit = limit;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
