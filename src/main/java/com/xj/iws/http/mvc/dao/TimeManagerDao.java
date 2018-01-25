package com.xj.iws.http.mvc.dao;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/13.
 */
@Repository
public interface TimeManagerDao {
    public void addTime(SimpleDateFormat dateFormat);
}
