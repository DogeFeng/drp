package com.yootk.drp.service.back.customer_manage_module;

import com.yootk.drp.vo.City;

import java.util.List;
import java.util.Map;

public interface ICityService {

    /**
     * 实现城市信息表单回填
     * @param pid 省份id
     * @return 该省份的所有城市信息
     * @throws Exception
     */
    public List<City> preAddCity(Long pid) throws Exception;
}
