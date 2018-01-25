package com.xj.iws.http.mvc.controller.extra;


import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.service.FileManageService;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */
@Controller
@RequestMapping("api/file")
public class FileManageController {


    @Autowired
    private FileManageService fileManageService;

    @RequestMapping("upload")
    @ResponseBody
    public DataWrapper<String> upload(HttpServletRequest request)
    {
        return fileManageService.upload(request);
    }

    @RequestMapping("download")
    @ResponseBody
    public DataWrapper<String> download(
            @RequestParam("fileName") String fileName,
            HttpServletRequest request, HttpServletResponse response
    ){
        return fileManageService.download(fileName,request,response);
    }
}
