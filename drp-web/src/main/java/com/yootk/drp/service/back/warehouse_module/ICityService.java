package com.yootk.drp.service.back.warehouse_module;

import com.yootk.drp.vo.City;

import java.util.List;

public interface ICityService {
    //返回省份对应城市信息
    public List<City> preAddCity(Long pid) throws Exception;
    /**
     * 实现城市信息表单回填
     * @param pid
     * @return
     * @throws Exception
     */
}
