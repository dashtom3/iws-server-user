package com.xj.iws.http.mvc.service;



import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.util.DataSave;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by 小月亮 on 2017/12/11.
 */

public interface SignInService {
    //添加
    public DataWrapper<DataSave> signIn(String token,DataSave dataSave);
    //查询
    public DataWrapper<List<DataSave>> querySignIn(Integer currentPage,Integer numberPerPage,DataSave dataSave);
    //导出表格
    public void export(HttpServletResponse response, DataSave dataSave);
    //定时任务
    public void timeManager(Integer time);
}

