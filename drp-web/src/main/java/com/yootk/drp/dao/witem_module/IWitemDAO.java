package com.yootk.drp.dao.witem_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IWitemDAO extends IBaseDAO<Long, Witem> {
    public Map<Long, String> findAllMap() throws SQLException ;
}
