package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.LocationService;
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
public class UsLocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    LimitationService limitationService;

    /**
     * 获取全部地点
     *
     * @return location
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<LocationEntity>> list(
            @RequestParam(value = "token", required = true)String token,
            @RequestParam(value = "systemId", required = false)int systemId,
            @ModelAttribute Page page
            ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations = limitationService.getLimit(user);
        return locationService.list(systemId,limitations,page);
    }
}
