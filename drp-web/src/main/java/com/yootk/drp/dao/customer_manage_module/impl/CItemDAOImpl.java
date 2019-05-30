package com.yootk.drp.dao.customer_manage_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.customer_manage_module.ICItemDAO;
import com.yootk.drp.vo.CItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class CItemDAOImpl extends AbstractDAO implements ICItemDAO {
    @Override
    public Map<Long, String> findAllMap() throws SQLException {
        Map<Long,String> map = new HashMap<>() ;
        String sql = "SELECT ciid,title FROM citem" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getLong(1),rs.getString(2)) ;
        }
        return map ;
    }

    @Override
    public boolean doCreate(CItem cItem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(CItem cItem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public CItem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<CItem> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<CItem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<CItem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
