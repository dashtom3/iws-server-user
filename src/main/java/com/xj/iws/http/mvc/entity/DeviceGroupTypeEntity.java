package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/17.
 */
@Alias("DeviceGroupTypeEntity")
public class DeviceGroupTypeEntity {
    private int id;
    private int systemId;
    private String name;
    private String describes;
    private String pic;

    List<DeviceGroupInfoEntity> groups;

    public DeviceGroupTypeEntity() {
    }

    public DeviceGroupTypeEntity(int id, int systemId, String name, String describes, String pic) {

        this.id = id;
        this.systemId = systemId;
        this.name = name;
        this.describes = describes;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<DeviceGroupInfoEntity> getGroups() {
        return groups;
    }

    public void setGroups(List<DeviceGroupInfoEntity> groups) {
        this.groups = groups;
    }
}
