package com.yootk.drp.dao.warehouse_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

public interface IWareHouseDAO extends IBaseDAO<Long, Warehouse> {
    /**
     * 根据仓库编号取得省份编号，用户城市的回填
     * @param wid 仓库编号
     * @return
     * @throws SQLException
     */
    public Long getPid(Long wid) throws SQLException;
}
