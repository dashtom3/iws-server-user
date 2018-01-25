package com.xj.iws.http.mvc.entity.util;

import com.xj.iws.common.enums.DataEnum;

/**
 * Created by XiaoJiang01 on 2017/4/18.
 */
public class DataField {
    private int number;
    private String name;
    private String data;
    private double value;
    private DataEnum exception;

    public DataField() {
        exception = DataEnum.No_Exception;
    }

    public DataField(int number, String name, String data, double value) {
        this.number = number;
        this.name = name;
        this.data = data;
        this.value = value;
        this.exception = DataEnum.No_Exception;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public DataEnum getException() {
        return exception;
    }

    public void setException(DataEnum exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "DataField{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", value=" + value +
                ", exception=" + exception +
                '}';
    }
}
