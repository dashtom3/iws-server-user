package com.xj.iws.http.mvc.entity.util;

/**
 * Created by XiaoJiang01 on 2017/4/12.
 */
public class Command {

    private String number;
    private int count;


    public Command() {
    }

    public Command(String number, int count) {
        this.number = number;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
