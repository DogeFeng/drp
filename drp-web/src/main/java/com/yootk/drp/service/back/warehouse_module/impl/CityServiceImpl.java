package com.yootk.drp.service.back.warehouse_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.warehouse_module.ICityDAO;
import com.yootk.drp.service.back.warehouse_module.ICityService;
import com.yootk.drp.vo.City;
import java.util.List;

@Service
public class CityServiceImpl extends AbstractService implements ICityService {
    @Autowired
    private ICityDAO cityDAO;
    @Override
    public List<City> preAddCity(Long pid) throws Exception {
        return cityDAO.findAllByProvince(pid);
    }
}
