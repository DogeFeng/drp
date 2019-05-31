package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICityDAO extends IBaseDAO<Long, City> {
    /**
     * 查询某省份的所有城市信息
     * @param pid 省份 id
     * @return 该省份所有城市的 List 集合
     */
    public List<City> findAllByProvince(Long pid) throws SQLException;
}
