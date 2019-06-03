package com.yootk.drp.service.back.city_module;

import com.yootk.common.annotation.Service;
import com.yootk.drp.vo.City;

import java.util.List;

public interface ICityServiceBack {
    public List<City> listByProvince(Long pid)throws Exception ;
}
