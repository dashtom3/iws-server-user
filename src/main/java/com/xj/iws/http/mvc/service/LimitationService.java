package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
public interface LimitationService {
    boolean checkAdmin(UserEntity user);

    boolean checkMaintainer(UserEntity user);

    boolean checkLimit(UserEntity user,int systemId,String areaId,int writable);

    List<Limitation> getLimit(UserEntity user);
}
