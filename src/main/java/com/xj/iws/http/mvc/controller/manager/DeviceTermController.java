package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.DeviceTypeEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.PointRoleEntity;
import com.xj.iws.http.mvc.service.DeviceTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/deviceTerm")
public class DeviceTermController {

    @Autowired
    DeviceTermService deviceTermService;

    /**
     * 获取点表字段规则
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "pointRole", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<PointRoleEntity>> pointRole(
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceTermService.pointRole();
    }

    /**
     * 添加控制器
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceTermEntity> addPointTable(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceTermEntity deviceTermEntity,
            @RequestBody PointFieldEntity[] fields
    ) {
        return deviceTermService.add(deviceTermEntity, fields);
    }

    /**
     * 删除控制器
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceTermId", required = true) int deviceTermId
    ) {
        return deviceTermService.delete(deviceTermId);
    }

    /**
     * 编辑控制器
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceTermEntity> update(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceTermEntity deviceTermEntity
    ) {
        return deviceTermService.update(deviceTermEntity);
    }

    /**
     * 获取控制器列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<DeviceTermEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "type", required = false) String type,
            @ModelAttribute Page page
    ) {
        return deviceTermService.list(type, page);
    }

    /**
     * 获取控制器详情
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceTermEntity> detail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceTermId", required = true) int deviceTermId
    ) {
        return deviceTermService.detail(deviceTermId);
    }

    /**
     * 获取控制器类型列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "typeList", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<DeviceTypeEntity>> typeList(
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceTermService.typeList();
    }

    /**
     * 查询控制器
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<DeviceTermEntity>> query(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "protocol", required = false) String protocol,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "name", required = false) String name
    ) {
        Map<String, String> condition = new HashMap<String, String>();
        condition.put("protocol", protocol);
        condition.put("type", type);
        condition.put("name", name);
        return deviceTermService.query(condition);
    }

    /**
     * 添加控制器
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<String> check(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute DeviceTermEntity deviceTermEntity,
            @RequestBody PointFieldEntity[] fields,
            @RequestParam(value = "port",required = true)String port,
            @RequestParam(value = "number",required = true)String number
    ) {
        int type = deviceTermEntity.getType();
        return deviceTermService.check(type,fields,port,number);
    }
}
