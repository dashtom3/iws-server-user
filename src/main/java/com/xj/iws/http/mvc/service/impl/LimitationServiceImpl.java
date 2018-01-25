package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.http.mvc.dao.RoleDao;
import com.xj.iws.http.mvc.entity.RoleSubEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
@Component
public class LimitationServiceImpl implements LimitationService {
    @Autowired
    RoleDao roleDao;

    @Override
    public boolean checkAdmin(UserEntity user) {
        boolean result = false;
        if(user!=null){
            if (-1 == user.getRoleId() || 1 == user.getRoleId()) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkMaintainer(UserEntity user){
        boolean result = false;
        if (-1 == user.getRoleId()) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean checkLimit(UserEntity user, int systemId, String areaId,int writable) {
        boolean result = false;

        //获取用户全部权限
        List<String> areaIds = roleDao.checkWritable(user.getRoleId(), systemId, writable);
        if ("00".equals(areaId.substring(4, 6))) {
            if ("0000".equals(areaId.substring(2, 6))) {
                //areaId 为省份id,查询该用户权限是否包含该省份
                for (String id : areaIds) {
                    if (id.equals(areaId)) {
                        result = true;
                        break;
                    }
                }
            } else {
                //areaId 为城市id,查询该用户权限是否包含该市,或包含上级
                for (String id : areaIds) {
                    if (id.equals(areaId)) {
                        result = true;
                        break;
                    } else if ("0000".equals(id.substring(2, 6))) {
                        if (id.substring(0, 2).equals(areaId.substring(0, 2))) {
                            result = true;
                            break;
                        }
                    }
                }
            }
        } else {
            //areaId 为城区id,查询该用户权限是否包含该城区,或包含上级
            for (String id : areaIds) {
                if (id.equals(areaId)) {
                    result = true;
                    break;
                } else if ("0000".equals(id.substring(2, 6))) {
                    if (id.substring(0, 2).equals(areaId.substring(0, 2))) {
                        result = true;
                        break;
                    }
                } else if ("00".equals(id.substring(4,6))){
                    if (id.substring(0,4).equals(areaId.substring(0,4))){
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<Limitation>                                                                                             getLimit(UserEntity user){
        List<Limitation> limitations = new ArrayList<Limitation>();
        if (checkAdmin(user)){
            Limitation limitation = new Limitation();
            limitations.add(limitation);
        }else if(user.getRoleId() == 0){
            Limitation limitation = new Limitation(-10,"No","No","No",-10);
            limitations.add(limitation);
        }else {
            List<RoleSubEntity> roles = roleDao.getLimit(user.getRoleId());
            for (RoleSubEntity role : roles) {
                Limitation limitation = new Limitation();
                limitation.setSystemId(role.getSystemId());
                limitation.setLimit(role.getLimitation());
                String areaId = role.getAreaId();
                if ("0000".equals(areaId.substring(2,6))){
                    limitation.setProvinceId(areaId);
                }else if ("00".equals(areaId.substring(4,6))){
                    limitation.setCityId(areaId);
                }else {
                    limitation.setAreaId(areaId);
                }
                limitations.add(limitation);
            }
        }
        return limitations;
    }
}
