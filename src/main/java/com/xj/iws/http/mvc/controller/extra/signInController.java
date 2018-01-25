package com.xj.iws.http.mvc.controller.extra;


import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.util.DataSave;
import com.xj.iws.http.mvc.service.SignInService;
import net.sf.jsqlparser.schema.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */
@Controller
@RequestMapping("api/signIn")
public class signInController {
    @Autowired
    SignInService signInService;
    @RequestMapping(value = "signIn",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DataSave> sign(
            @RequestParam(value = "token")String token,
            @ModelAttribute DataSave dataSave){
        DataWrapper<DataSave> dw=signInService.signIn(token,dataSave);
        //签到，添加数据

        return dw;
    }
    //条件查询
    @RequestMapping(value = "querySignIn",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<DataSave>> querySignIn(
            @RequestParam(value = "currentPage",required = false,defaultValue = "1")Integer currentPage,
            @RequestParam(value = "numberPerPage",required = false,defaultValue = "10")Integer numberPerPage,
            @ModelAttribute DataSave dataSave
    ){

        return signInService.querySignIn(currentPage,numberPerPage,dataSave);
    }
    //导出表格
    @RequestMapping(value = "Export",method = RequestMethod.GET)
    @ResponseBody
    public void export(HttpServletResponse response,
            @ModelAttribute DataSave dataSave
    ) {

      signInService.export(response, dataSave);

    }
    //定时任务
    @RequestMapping(value = "time",method = RequestMethod.GET)
    @ResponseBody
    public void timeManager(Integer time){
        signInService.timeManager(time);
    }
}
