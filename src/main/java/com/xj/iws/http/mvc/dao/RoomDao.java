package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.RoomEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Repository
public interface RoomDao {
    int add(RoomEntity roomEntity);

    int delete(int roomId);

    int update(RoomEntity roomEntity);

    List<RoomEntity> list(int locationId);

    RoomEntity detail(int roomId);
}
