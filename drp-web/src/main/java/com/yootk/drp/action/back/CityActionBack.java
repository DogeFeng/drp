package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.drp.service.back.city_module.ICityServiceBack;
@Controller
@RequestMapping("/pages/back/admin/city/")
public class CityActionBack extends AbstractAction {
    @Autowired
    private ICityServiceBack cityService ;
    @RequestMapping("city_list")
    public void listCity(Long pid){
        try {
            super.print(JSONObject.toJSONString(this.cityService.listByProvince(pid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
