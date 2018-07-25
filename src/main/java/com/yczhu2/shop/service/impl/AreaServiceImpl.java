package com.yczhu2.shop.service.impl;

import com.yczhu2.shop.dao.AreaDao;
import com.yczhu2.shop.entity.Area;
import com.yczhu2.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author yczhu2
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int id) {

        return areaDao.queryAreaById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public Boolean updateArea(Area area) {
        if (area.getAreaId() != null && !"".equals(area.getAreaId())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public Boolean deleteArea(int id) {
        if (id > 0) {

            try {
                int eff = areaDao.deleteArea(id);
                if (eff > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域id不能为空！");
        }

    }
}
