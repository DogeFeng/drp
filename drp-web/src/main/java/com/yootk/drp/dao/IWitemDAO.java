package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.Map;

public interface IWitemDAO extends IBaseDAO<Long, Witem> {
    public Map<Long, String> findAllMap() throws SQLException;
}
