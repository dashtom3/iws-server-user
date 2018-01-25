package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupInfoEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupTypeEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.DeviceService;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.RoomService;
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
@RequestMapping("api/room")
public class UsRoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    LimitationService limitationService;

    /**
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "manual", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> manual(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId",required = true) String deviceId,
            @RequestParam(value = "number",required = true) String number,
            @RequestParam(value = "pumpStatus",required = true) String pumpStatus
    ) {
        return roomService.turnPump(deviceId,number,pumpStatus);
    }


}
