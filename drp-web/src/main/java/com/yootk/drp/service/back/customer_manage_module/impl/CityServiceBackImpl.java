package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.customer_manage_module.ICityDAO;
import com.yootk.drp.service.back.customer_manage_module.ICityServiceBack;
import com.yootk.drp.vo.City;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceBackImpl extends AbstractService implements ICityServiceBack {
    @Autowired
    private ICityDAO cityDAO;
    @Override
    public List<City> preAddCity(Long pid) throws Exception {
        return cityDAO.findAllByProvince(pid);
    }
}
