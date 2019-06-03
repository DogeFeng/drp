package com.yootk.drp.dao.city_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    /**
     * 根据省份编号创建相应的城市数据信息
     * @param pid 省份编号
     * @return 对应的城市内容
     * @throws SQLException SQL异常
     */
    public List<City> findAllProvince(Long pid)throws SQLException ;
}
