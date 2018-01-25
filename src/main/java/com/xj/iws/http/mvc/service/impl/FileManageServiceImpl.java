package com.xj.iws.http.mvc.service.impl;


import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.service.FileManageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/12/12.
 */
@Service
public class FileManageServiceImpl implements FileManageService {

    private static final String PREFIX="http://61.190.61.78:6784/iws/";
    private static final String API="api/file/download?fileName=";


    @Override
    public DataWrapper<String> upload(HttpServletRequest request) {
        DataWrapper dataWrapper = new DataWrapper();
        long startTime = System.currentTimeMillis();

        try {
            CommonsMultipartResolver e = new CommonsMultipartResolver(request.getSession().getServletContext());
            if(e.isMultipart(request)) {
                MultipartHttpServletRequest endTime = (MultipartHttpServletRequest)request;
                Iterator iter = endTime.getFileNames();

                while(iter.hasNext()) {
                    MultipartFile file = endTime.getFile(iter.next().toString());
                    if(file != null) {
                        String path = request.getServletContext().getRealPath("WEB-INF/File/");
                        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
                        file.transferTo(new File(path, fileName));
                        dataWrapper.setData(PREFIX+API+fileName);
                    }
                }
            }

            long endTime1 = System.currentTimeMillis();
            System.out.println("方法三的运行时间：" + String.valueOf(endTime1 - startTime) + "ms");
        } catch (Exception var11) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }

        return dataWrapper;
    }

    @Override
    public DataWrapper<String> download(String fileName, HttpServletRequest request, HttpServletResponse response) {
        DataWrapper<String> dataWrapper=new DataWrapper<String>();
        if (fileName != null) {
            String realPath = request.getServletContext().getRealPath("WEB-INF/File/");
                        File file = new File(realPath, fileName);
                        if (file.exists()) {
                                response.setContentType("application/force-download");// 设置强制下载不打开
                                response.addHeader("Content-Disposition",
                                                "attachment;fileName=" + fileName);// 设置文件名
                                byte[] buffer = new byte[1024];
                                FileInputStream fis = null;
                                BufferedInputStream bis = null;
                                try {
                                        fis = new FileInputStream(file);
                                        bis = new BufferedInputStream(fis);
                                        OutputStream os = response.getOutputStream();
                                      int i = bis.read(buffer);
                                       while (i != -1) {
                                                os.write(buffer, 0, i);
                                              i = bis.read(buffer);
                                           }
                                   } catch (Exception e) {
                                        // TODO: handle exception
                                       e.printStackTrace();
                                   } finally {
                                       if (bis != null) {
                                                try {
                                                        bis.close();
                                                    } catch (IOException e) {
                                                        // TODO Auto-generated catch block
                                                       e.printStackTrace();
                                                    }
                                          }
                                       if (fis != null) {
                                              try {
                                                        fis.close();
                                                    } catch (IOException e) {
                            // TODO Auto-generated catch block
                                                        e.printStackTrace();
                                                    }
                                            }
                                     }
                            }
                    }
                return dataWrapper;
    }
}
