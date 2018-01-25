package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/24.
 */
@Alias("PointFieldEntity")
public class PointFieldEntity {
    private int id;
    private int termId;
    private int number;
    private int roleId;
    private String name;
    private String describes;
    private String unit;
    private double min;
    private double max;
    private int multiple;
    private String address;
    private int modelId;
    private Integer length;

    private List<String> status;

    private DeviceTermEntity table;

    public PointFieldEntity() {
    }

    public PointFieldEntity(int id, int termId, int number, int roleId, String name, String describes, String unit, double min, double max, int multiple, String address, int modelId, Integer length, List<String> status, DeviceTermEntity table) {
        this.id = id;
        this.termId = termId;
        this.number = number;
        this.roleId = roleId;
        this.name = name;
        this.describes = describes;
        this.unit = unit;
        this.min = min;
        this.max = max;
        this.multiple = multiple;
        this.address = address;
        this.modelId = modelId;
        this.length = length;
        this.status = status;
        this.table = table;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public DeviceTermEntity getTable() {
        return table;
    }

    public void setTable(DeviceTermEntity table) {
        this.table = table;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PointFieldEntity{" +
                "id=" + id +
                ", termId=" + termId +
                ", number=" + number +
                ", roleId=" + roleId +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", unit='" + unit + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", multiple=" + multiple +
                ", address='" + address + '\'' +
                ", modelId=" + modelId +
                ", length=" + length +
                ", status=" + status +
                ", table=" + table +
                '}';
    }
}
