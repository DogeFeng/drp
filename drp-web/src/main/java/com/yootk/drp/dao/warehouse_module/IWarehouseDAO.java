package com.yootk.drp.dao.warehouse_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;

public interface IWarehouseDAO extends IBaseDAO<Long, Warehouse> {
    /**
     * 根据仓库ID查找对应的省份ID
     * @param wid 仓库ID
     * @return 返回对应的省份信息
     * @throws SQLException SQL执行异常
     */
    public Long findByPid(Long wid)throws SQLException ;
}
