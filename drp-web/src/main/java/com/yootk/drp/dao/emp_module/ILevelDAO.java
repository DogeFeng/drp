package com.yootk.drp.dao.emp_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Level;

import java.sql.SQLException;
import java.util.Map;

public interface ILevelDAO extends IBaseDAO<Integer, Level> {
    /**
     * 查询所有 Level
     * @return  Map 集合
     * key = lid，value = title
     */
    public Map<Long,String> findAllMap() throws SQLException;
}
