package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.util.DataSave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */
@Repository
public interface SignInDao {
    //添加
    public Integer signIn(DataSave dataSave);

    //查询
    public List<DataSave> querySignIn(
            @Param("dataSave")DataSave dataSave,
            @Param("currentNumber")int currentNumber,
            @Param("numberPerPage")int numberPerPage
           );
    //查询总条数
    public  Integer tataCount(DataSave dataSave);
    //导出表格
    public List<DataSave> export(@Param("dataSave") DataSave dataSave);
    //定时任务
    public void timeManager(String time);
}