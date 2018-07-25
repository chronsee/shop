package com.yczhu2.shop.web;

import com.yczhu2.shop.entity.Area;
import com.yczhu2.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yczhu2
 */
@RestController
@EnableSwagger2
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.queryArea();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getAreaById", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer id) {
        Area area = areaService.queryAreaById(id);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("areaList", area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;

    }

    @RequestMapping(value = "/updatearea", method = RequestMethod.POST)
    private Map<String, Object> uddateArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.updateArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/deletearea", method = RequestMethod.GET)
    private Map<String, Object> deleteArea(Integer id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(id));
        return modelMap;
    }
}
