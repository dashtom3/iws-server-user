package com.xj.iws.http.mvc.controller.customer;

import com.xj.iws.http.mvc.entity.area.AreaEntity;
import com.xj.iws.http.mvc.entity.area.CityEntity;
import com.xj.iws.http.mvc.entity.area.ProvinceEntity;
import com.xj.iws.http.mvc.service.AreaService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Controller
@RequestMapping("api/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    /**
     * 获取全部省份
     * @return
     */
    @RequestMapping(value = "provinces", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<ProvinceEntity>> provinces(){
        return areaService.provinces();
    }

    /**
     * 获取全部城市及其所在省份
     * @return
     */
    @RequestMapping(value = "cities" ,method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<ProvinceEntity>> cities(){
        return areaService.cities();
    }

    /**
     * 获取全部地区及其所在城市、省份
     * @return
     */
    @RequestMapping(value = "areas",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<ProvinceEntity>> areas(){
        return areaService.areas();
    }

    /**
     * 获取某一省份及其下属城市
     * @param provinceId
     * @return
     */
    @RequestMapping(value = "province",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<ProvinceEntity> province(
            @RequestParam(value = "provinceId",required = true) int provinceId
    ){
        return areaService.province(provinceId);
    }

    /**
     * 获取某一城市及其所在省份、下属地区
     * @param cityId
     * @return
     */
    @RequestMapping(value = "city",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<CityEntity> city(
            @RequestParam(value = "cityId",required = true) int cityId
    ){
        return areaService.city(cityId);
    }

    /**
     * 获取某一地区及其所在城市、省份
     * @param areaId
     * @return
     */
    @RequestMapping(value = "area",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<AreaEntity> area(
            @RequestParam(value = "areaId",required = true) int areaId
    ){
        return areaService.area(areaId);
    }
}
