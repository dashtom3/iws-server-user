package com.xj.iws.http.mvc.service;


import com.xj.iws.common.utils.DataWrapper;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */
public interface FileManageService {
    DataWrapper<String> upload(HttpServletRequest request);

    DataWrapper<String> download(String fileName, HttpServletRequest request, HttpServletResponse response);
}
