package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.CItem;

import java.sql.SQLException;
import java.util.Map;

public interface ICItemDAO extends IBaseDAO<Long, CItem> {
    /**
     * 查询所有的客户等级
     * @return Map 集合
     * key = ciid，value = title
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
