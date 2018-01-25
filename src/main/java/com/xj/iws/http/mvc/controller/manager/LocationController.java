package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.LocationService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部地点设置请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    LimitationService limitationService;

    /**
     * 添加地点
     *
     * @return boolean
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<LocationEntity> add(
            @ModelAttribute LocationEntity locationEntity,
            @RequestParam(value = "token", required = true) String token
    ) {
        return locationService.add(locationEntity);
    }

    /**
     * 删除地点
     *
     * @return boolean
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "locationId", required = true) int locationId,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.delete(locationId);
    }

    /**
     * 编辑地点
     *
     * @return boolean
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute LocationEntity locationEntity,
            @RequestParam(value = "token", required = true) String token

    ) {
        return locationService.update(locationEntity);
    }

    /**
     * 获取某一地点及地点下全部泵房
     *
     * @return location
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<LocationEntity> detail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "locationId", required = true) int locationId
    ) {
        return locationService.detail(locationId);
    }

    /**
     * 条件查询,获取条件下全部地点
     * province,city,area中按一项查询，若同时存在则优先级为area,city,province
     *
     * @param systemId
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<LocationEntity>> query(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "systemId", required = false) String systemId,
            @RequestParam(value = "provinceId", required = false) String provinceId,
            @RequestParam(value = "cityId", required = false) String cityId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @ModelAttribute Page page
            ) {
        //创建查询条件
        Map<String, String> condition = new HashMap<String, String>();
        if (systemId != null && !"".equals(systemId)){
            condition.put("systemId", systemId);
        }
        if (areaId != null && !"".equals(areaId)) {
            condition.put("areaId", areaId);
        } else if (cityId != null && !"".equals(cityId)) {
            condition.put("cityId", cityId);
        } else if (provinceId != null && !"".equals(provinceId)) {
            condition.put("provinceId", provinceId);
        }
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations=null;
        if(user!=null){
            limitations = limitationService.getLimit(user);
        }
        return locationService.query(condition,limitations,page);
    }
}
