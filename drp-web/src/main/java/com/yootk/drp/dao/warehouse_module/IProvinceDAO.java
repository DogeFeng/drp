package com.yootk.drp.dao.warehouse_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.Map;

public interface IProvinceDAO extends IBaseDAO<Long, Province> {
    /**
     * 用于列表展示时的省份信息回显
     * @return
     * @throws SQLException
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
