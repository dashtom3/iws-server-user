package com.xj.iws.http.mvc.entity;

/**
 * Created by Administrator on 2017/12/14.
 */
public class Location {
    private Integer locationId;
    private String describes;
    private Double positionx;
    private Double positiony;
    private Integer areaid;
    private Integer cityid;
    private Integer provinceid;
    private Integer systemid;
    private Integer totalNumber;
    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Double getPositionx() {
        return positionx;
    }

    public void setPositionx(Double positionx) {
        this.positionx = positionx;
    }

    public Double getPositiony() {
        return positiony;
    }

    public void setPositiony(Double positiony) {
        this.positiony = positiony;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getSystemid() {
        return systemid;
    }

    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    @Override
    public String toString() {
        return "location{" +
                "describes='" + describes + '\'' +
                ", positionx=" + positionx +
                ", positiony=" + positiony +
                ", areaid=" + areaid +
                ", cityid=" + cityid +
                ", provinceid=" + provinceid +
                ", systemid=" + systemid +
                ", totalNumber=" + totalNumber +
                '}';
    }
}
