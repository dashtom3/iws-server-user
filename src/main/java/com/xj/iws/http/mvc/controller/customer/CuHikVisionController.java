package com.xj.iws.http.mvc.controller.customer;

import com.xj.iws.common.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api/hikvision")
public class CuHikVisionController {

    @RequestMapping(value = "downloadComponent",method = RequestMethod.GET)
    @ResponseBody
    public void downloadComponent(
            HttpServletRequest request, HttpServletResponse response
    ){
        String fileName = "WebComponentsKit.exe";
        FileUtil.download(fileName,request,response);
    }
}
