package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.City;
import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    /**
     * 根据省份编号查询相应城市信息
     * @param pid 省份编号
     * @return 对应的城市信息
     * @throws SQLException JDBC异常
     */
    public List<City> findAllByProvince(Long pid) throws SQLException;
}
