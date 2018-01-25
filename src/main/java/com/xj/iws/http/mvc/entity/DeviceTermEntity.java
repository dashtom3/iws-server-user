package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/24.
 */
@Alias("DeviceTermEntity")
public class DeviceTermEntity {
    private int id;
    private int count;
    private String protocol;
    private int type;
    private String name;
    private String describes;
    private Integer start;

    private List<PointFieldEntity> fields;

    private String typeName;

    public DeviceTermEntity() {
    }

    public DeviceTermEntity(int id, int count, String protocol, int type, String name, String describes, Integer start, List<PointFieldEntity> fields, String typeName) {
        this.id = id;
        this.count = count;
        this.protocol = protocol;
        this.type = type;
        this.name = name;
        this.describes = describes;
        this.start = start;
        this.fields = fields;
        this.typeName = typeName;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public List<PointFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<PointFieldEntity> fields) {
        this.fields = fields;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
