package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 角色信息实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("RoleEntity")
public class RoleEntity {
    private int id;
    private String name;
    private String describes;

    private List<RoleSubEntity> subitem;

    public RoleEntity() {
    }

    public RoleEntity(int id, String name, String describes) {
        this.id = id;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<RoleSubEntity> getSubitem() {
        return subitem;
    }

    public void setSubitem(List<RoleSubEntity> subitem) {
        this.subitem = subitem;
    }
}
