package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部系统请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/model")
public class ModelController {

    @Autowired
    ModelService modelService;

    /**
     * 添加模型参数
     * @param fieldId
     * @param token
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @RequestParam(value = "token",required = true) String token,
            @RequestParam(value = "fieldId",required = true) String fieldId
    ){
        return modelService.add(fieldId);
    }

    /**
     * 删除模型参数
     * @param termId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "token",required = true) String token,
            @RequestParam(value = "termId",required = true) int termId
    ){
        return modelService.delete(termId);
    }

    /**
     * 编辑模型参数
     * @param fieldId
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @RequestParam(value = "token",required = true) String token,
            @RequestParam(value = "fieldId",required = true) String fieldId
    ){
        return modelService.update(fieldId);
    }

    /**
     * 查询详情
     * @param fieldId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<PointFieldEntity> detail(
            @RequestParam(value = "token",required = true) String token,
            @RequestParam(value = "fieldId",required = true) int fieldId
    ){
        return modelService.detail(fieldId);
    }

    /**
     * 查询列表
     * @param token
     * @param termId
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<PointFieldEntity>> list(
            @RequestParam(value = "token",required = true) String token,
            @RequestParam(value = "termId",required = true) int termId
    ){
        return modelService.list(termId);
    }
}
