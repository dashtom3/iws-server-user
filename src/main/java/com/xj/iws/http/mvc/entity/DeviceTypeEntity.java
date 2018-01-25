package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceTypeEntity")
public class DeviceTypeEntity {
    private int id;
    private int bit;
    private String name;
    private String pic;
    private String describes;

    public DeviceTypeEntity() {
    }

    public DeviceTypeEntity(int id, int bit, String name, String pic, String describes) {
        this.id = id;
        this.bit = bit;
        this.name = name;
        this.pic = pic;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
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
}
