package com.yczhu2.shop.dao;

import com.yczhu2.shop.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yczhu2
 */
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int id);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int id);
}
