package com.yczhu2.shop.service;

import com.yczhu2.shop.entity.Area;

import java.util.List;

/**
 * @author yczhu2
 */
public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int id);
    Boolean insertArea(Area area);
    Boolean updateArea(Area area);
    Boolean deleteArea(int id);
}
