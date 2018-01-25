package com.xj.iws.common.utils;

import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.http.mvc.entity.area.AreaEntity;
import com.xj.iws.http.mvc.entity.area.CityEntity;
import com.xj.iws.http.mvc.entity.area.ProvinceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/27.
 */
public class PackageUtil {

    /**
     * 按省市区封装地点
     *
     * @param locations
     * @return
     */
    public static List<ProvinceEntity> locationPack(List<LocationEntity> locations) {
        if (locations.size() == 0){
            return null;
        }

        //创建结束项
        LocationEntity end = new LocationEntity();
        end.setAreaId(0);
        end.setCityId(0);
        end.setProvinceId(0);
        locations.add(end);

        //创建初始id
        int i = locations.get(0).getAreaId(), j = locations.get(0).getCityId(), k = locations.get(0).getProvinceId();
        int areaId, cityId, provinceId;

        AreaEntity area = new AreaEntity();
        CityEntity city = new CityEntity();
        ProvinceEntity province = new ProvinceEntity();

        List<LocationEntity> locationPack = new ArrayList<LocationEntity>();
        List<AreaEntity> areaPack = new ArrayList<AreaEntity>();
        List<CityEntity> cityPack = new ArrayList<CityEntity>();
        List<ProvinceEntity> provincePack = new ArrayList<ProvinceEntity>();

        //遍历列表进行封装
        for (int n = 0; n < locations.size(); n++) {
            LocationEntity location = locations.get(n);

            areaId = location.getAreaId();
            cityId = location.getCityId();
            provinceId = location.getProvinceId();

            if (areaId == i) {
                locationPack.add(location);

                area.setAreaId(areaId);
                area.setName(location.getAreaName());

                city.setCityId(cityId);
                city.setName(location.getCityName());

                province.setProvinceId(provinceId);
                province.setName(location.getProvinceName());
            } else {
                i = areaId;

                area.setLocation(locationPack);
                areaPack.add(area);

                area = new AreaEntity();
                locationPack = new ArrayList<LocationEntity>();

                n--;
                if (cityId != j) {
                    j = cityId;

                    city.setArea(areaPack);
                    cityPack.add(city);

                    city = new CityEntity();
                    areaPack = new ArrayList<AreaEntity>();

                    if (provinceId != k) {
                        k = provinceId;

                        province.setCity(cityPack);
                        provincePack.add(province);

                        province = new ProvinceEntity();
                        cityPack = new ArrayList<CityEntity>();
                    }
                }
            }
        }
        return provincePack;
    }

    /**
     * 按控制器终端封装字段
     *
     * @param deviceTerms
     * @param fields
     * @return
     */
    public static List<DeviceTermEntity> deviceTermPack(List<DeviceTermEntity> deviceTerms, List<PointFieldEntity> fields) {

        if (deviceTerms.size() == 0) {
            return deviceTerms;
        }

        List<PointFieldEntity> fieldPack = new ArrayList<PointFieldEntity>();

        PointFieldEntity end = new PointFieldEntity();
        end.setTermId(0);
        fields.add(end);
        int i = fields.get(0).getTermId();
        for (int j = 0; j < fields.size(); j++) {
            PointFieldEntity field = fields.get(j);
            int deviceId = field.getTermId();

            if (i == deviceId) {
                fieldPack.add(field);
            } else {
                for (DeviceTermEntity deviceTerm : deviceTerms) {
                    if (deviceTerm.getId() == fields.get(j - 1).getTermId()) {
                        deviceTerm.setFields(fieldPack);
                        break;
                    }
                }
                fieldPack = new ArrayList<PointFieldEntity>();
                fieldPack.add(field);
                i = field.getTermId();
            }
        }
        return deviceTerms;
    }

    /**
     * 按控制器组封装控制器
     *
     * @param groups
     * @param devices
     * @return
     */
    public static List<DeviceGroupInfoEntity> devicePack(List<DeviceGroupInfoEntity> groups, List<DeviceEntity> devices) {
        if (groups.size() == 0) {
            return groups;
        }

        List<DeviceEntity> devicePack = new ArrayList<DeviceEntity>();

        DeviceEntity end = new DeviceEntity();
        end.setGroupId(0);
        devices.add(end);

        int i = devices.get(0).getId();
        for (int j = 0; j < devices.size(); j++) {
            DeviceEntity device = devices.get(j);
            int groupId = device.getGroupId();
            if (i == groupId) {
                devicePack.add(device);
            } else {

                for (DeviceGroupInfoEntity group : groups) {
                    if (group.getId() == devices.get(j - 1).getGroupId()) {
                        group.setDevices(devicePack);
                        break;
                    }
                }
                devicePack = new ArrayList<DeviceEntity>();
                devicePack.add(device);
                i = device.getGroupId();
            }
        }
        return groups;
    }


    public static List<LocationEntity> locationSetSystem(List<LocationEntity> locations, List<SystemEntity> systems) {
        if (locations.size() == 0) {
            return locations;
        }


        for (LocationEntity location : locations) {

            int systemId = location.getSystemId();

            for (int i = 0; i < systems.size(); i++) {
                SystemEntity system = systems.get(i);
                int id = system.getId();
                if (id == systemId) {
                    location.setSystem(system);
                    break;
                }
            }
        }
        return locations;
    }
}