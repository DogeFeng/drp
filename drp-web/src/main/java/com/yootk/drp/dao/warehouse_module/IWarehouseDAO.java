package com.yootk.drp.dao.warehouse_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

public interface IWarehouseDAO extends IBaseDAO<Long, Warehouse> {
    public Long getPid(Long wid) throws SQLException ;
}
