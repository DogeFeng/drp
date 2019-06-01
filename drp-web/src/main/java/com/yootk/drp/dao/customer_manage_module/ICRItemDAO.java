package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.CRItem;

import java.sql.SQLException;
import java.util.Map;

public interface ICRItemDAO extends IBaseDAO<Long, CRItem> {
    /**
     * 查询所有客户联系类型
     * @return
     * @throws SQLException
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
