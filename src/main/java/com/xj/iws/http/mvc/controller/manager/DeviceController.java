package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupInfoEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupTypeEntity;
import com.xj.iws.http.mvc.service.DeviceService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部控制器请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    /**
     * 创建控制器组
     * @param deviceGroup
     * @param token
     * @return
     */
    @RequestMapping(value = "addGroup",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceGroupInfoEntity> addGroup(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceGroupInfoEntity deviceGroup
    ) {
        return deviceService.addGroup(deviceGroup);
    }

    /**
     * 删除控制器组
     * @param groupId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) int groupId
    ) {
        return deviceService.delete(groupId);
    }

    /**
     * 编辑控制器组
     * @param deviceGroup
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceEntity> update(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceGroupInfoEntity deviceGroup
    ) {
        return deviceService.update(deviceGroup);
    }

    /**
     * 控制器组列表
     * @param token
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<DeviceGroupInfoEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute Page page
            ) {
        return deviceService.groupList(page);
    }

    /**
     * 控制器组列表
     * @param token
     * @return
     */
    @RequestMapping(value = "groupType",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<DeviceGroupTypeEntity>> groupType(
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.groupType();
    }

    /**
     * 控制器组详情
     * @param groupId
     * @param token
     * @return
     */
    @RequestMapping(value = "groupDetail",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<DeviceGroupInfoEntity> groupDetail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) int groupId
    ) {
        return deviceService.groupDetail(groupId);
    }


}
