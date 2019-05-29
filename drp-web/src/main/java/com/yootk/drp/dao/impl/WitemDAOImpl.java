package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IWitemDAO;
import com.yootk.drp.vo.Witem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository
public class WitemDAOImpl extends AbstractDAO implements IWitemDAO {
    @Override
    public boolean doCreate(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Witem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findAll() throws SQLException {
         String sql = "SELECT wiid,title FROM witem";
         super.pstmt = super.conn.prepareStatement(sql);
         return super.handleResultToList(super.pstmt.executeQuery(),Witem.class);
    }
    public Map<Long, String> findAllMap() throws SQLException {
        Map<Long,String > map = new HashMap<>();
        String sql = "SELECT wiid,title FROM witem";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            map.put((long) rs.getInt(1),rs.getString(2));
        }
        return map;
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
