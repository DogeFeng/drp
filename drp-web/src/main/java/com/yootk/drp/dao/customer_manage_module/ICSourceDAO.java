package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.CSource;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.Map;

public interface ICSourceDAO extends IBaseDAO<Long, CSource> {
    /**
     * 查询所有的客户等级
     * @return Map 集合
     * key = csid，value = title
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
