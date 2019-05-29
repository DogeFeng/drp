package com.yootk.drp.dao.impl;

import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IStorageApplyDetailsDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageApplyDetailsDAOImpl  extends AbstractDAO implements IStorageApplyDetailsDAO {
    @Override
    public boolean doCreate(StorageApplyDetails storageApplyDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(StorageApplyDetails storageApplyDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public StorageApplyDetails findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<StorageApplyDetails> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<StorageApplyDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<StorageApplyDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Map<Long, Integer> findAllByStorageApply(Long sadid) throws SQLException {
        Map<Long,Integer> map = new HashMap<>() ;
        String sql = "SELECT gid,name,num,price,weight FROM storage_apply_details WHERE sadid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,sadid);
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getLong(1),rs.getInt(2)) ;
        }
        return map ;
    }
}
