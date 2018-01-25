package com.xj.iws.http.mvc.entity;

import com.xj.iws.http.mvc.entity.area.ProvinceEntity;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * 系统资料实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("SystemEntity")
public class SystemEntity {

    private int id;
    private Date date;
    private String strdate;
    private String name;
    private String pic;
    private String describes;

    private List<ProvinceEntity> locationPack;
    private List<LocationEntity> location;

    public SystemEntity(int id, Date date, String strdate, String name, String pic, String describes) {
        this.id = id;
        this.date = date;
        this.strdate = strdate;
        this.name = name;
        this.pic = pic;
        this.describes = describes;
    }

    public SystemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStrdate() {
        return strdate;
    }

    public void setStrdate(String strdate) {
        this.strdate = strdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<ProvinceEntity> getLocationPack() {
        return locationPack;
    }

    public void setLocationPack(List<ProvinceEntity> locationPack) {
        this.locationPack = locationPack;
    }

    public List<LocationEntity> getLocation() {
        return location;
    }

    public void setLocation(List<LocationEntity> location) {
        this.location = location;
    }
}
