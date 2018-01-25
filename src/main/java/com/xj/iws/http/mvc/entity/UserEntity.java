package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 用户信息实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("UserEntity")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private int roleId;
    private int status;
    private Date date;
    private String name;
    private String address;
    private String describes;
    private String pic;

    private String roleName;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String password, int roleId, int status, Date date, String name, String address, String describes, String pic) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
        this.date = date;
        this.name = name;
        this.address = address;
        this.describes = describes;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
