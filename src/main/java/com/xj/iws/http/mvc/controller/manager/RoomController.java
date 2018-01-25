package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.http.mvc.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Controller
@RequestMapping("api/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    /**
     * 添加泵房
     *
     * @return boolean
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoomEntity> add(
            @ModelAttribute RoomEntity roomEntity,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roomService.add(roomEntity);
    }

    /**
     * 删除泵房
     *
     * @return boolean
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "roomId", required = true) int roomId,
            @RequestParam(value = "token", required = true) String token

    ) {
        return roomService.delete(roomId);
    }

    /**
     * 编辑泵房
     *
     * @return boolean
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoomEntity> update(
            @ModelAttribute RoomEntity roomEntity,
            @RequestParam(value = "token", required = true) String token

    ) {
        return roomService.update(roomEntity);
    }

    /**
     * 获取某一泵房及泵房所属地点、泵房内所有控制器
     *
     * @return room
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoomEntity> detail(
            @RequestParam(value = "roomId", required = true) int roomId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roomService.detail(roomId);
    }

    /**
     * 添加控制器组
     *
     * @return room
     */
    @RequestMapping(value = "addDevice", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> addDevice(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceGroupEntity groupEntity,
            @RequestBody DeviceEntity[] terms
    ) {
        return roomService.addDevice(groupEntity, terms);
    }

    /**
     * 修改控制器组
     *
     * @return room
     */
    @RequestMapping(value = "updateDevice", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> updateDevice(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceEntity deviceEntity
    ) {
        return roomService.updateDevice(deviceEntity);
    }

    /**
     * 删除控制器组
     *
     * @return room
     */
    @RequestMapping(value = "deleteDevice", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> deleteDevice(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) int groupId
    ) {
        return roomService.deleteDevice(groupId);
    }

    /**
     * 控制器组列表
     *
     * @return room
     */
    @RequestMapping(value = "groupList", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<DeviceGroupEntity>> deviceList(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "roomId", required = true) int roomId
    ) {
        return roomService.groupList(roomId);
    }

    /**
     * 控制器组详情
     *
     * @return room
     */
    @RequestMapping(value = "groupDetail", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<DeviceGroupEntity> groupDetail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) int groupId
    ) {
        return roomService.groupDetail(groupId);
    }

    /**
     * 控制器详情
     *
     * @return room
     */
    @RequestMapping(value = "deviceDetail", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<DeviceEntity> deviceDetail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId", required = true) int deviceId
    ) {
        return roomService.deviceDetail(deviceId);
    }

    /**
     * 数据采集启动
     * @param token
     * @param groupId
     * @return
     */
    @RequestMapping(value = "start", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> start(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) String groupId
    ) {
        return roomService.start(groupId);
    }

    /**
     * 数据采集关闭
     * @param token
     * @param groupId
     * @return
     */
    @RequestMapping(value = "close", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> close(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "groupId", required = true) String groupId
    ) {
        return roomService.close(groupId);
    }

    /**
     *
     * @param token
     * @param groupEntity
     * @param terms
     * @return
     */
    @RequestMapping(value = "testDevice", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Map<String,String>> test(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceGroupEntity groupEntity,
            @RequestBody DeviceEntity[] terms
    ) {
        return roomService.test(groupEntity,terms);
    }



}
