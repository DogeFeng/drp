package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.vo.Dept;

import java.sql.SQLException;
import java.util.Map;

public interface IDeptDAO extends IBaseDAO<Integer, Dept> {
    /**
     * 查询所有 Level
     * @return  Map 集合
     * key = did，value = dname
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
