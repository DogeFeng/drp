package com.yootk.drp.dao.customer_manage_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.customer_manage_module.ICRItemDAO;
import com.yootk.drp.vo.CRItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class CRItemDAOImpl extends AbstractDAO implements ICRItemDAO {
    @Override
    public boolean doCreate(CRItem crItem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(CRItem crItem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public CRItem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<CRItem> findAll() throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        String sql = "SELECT criid,title FROM critem" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToList(super.pstmt.executeQuery(),CRItem.class);
    }

    @Override
    public List<CRItem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<CRItem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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

    @Override
    public Map<Long, String> findAllMap() throws SQLException {
        Map<Long,String> map = new HashMap<>() ;
        String sql = "SELECT criid,title FROM critem" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getLong(1),rs.getString(2)) ;
        }
        return map ;
    }
}
