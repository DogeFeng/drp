package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.service.back.ICityService;
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
