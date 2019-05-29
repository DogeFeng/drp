package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:30
 * @Description:
 */
public interface IWitemDAO extends IBaseDAO<Long, Witem> {
    public Map<Long,String> findAllMap() throws SQLException;
}
