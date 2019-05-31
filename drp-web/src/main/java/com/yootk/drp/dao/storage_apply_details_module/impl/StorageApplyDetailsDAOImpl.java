package com.yootk.drp.dao.storage_apply_details_module.impl;

import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.storage_apply_details_module.IStorageApplyDetailsDAO;
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
        String sql = "INSERT INTO storage_apply_details(said,gid,name,num,price,weight)VALUES(?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,storageApplyDetails.getSadid());
        super.pstmt.setLong(2,storageApplyDetails.getGid());
        super.pstmt.setString(3,storageApplyDetails.getName());
        super.pstmt.setInt(4,storageApplyDetails.getNum());
        super.pstmt.setDouble(5,storageApplyDetails.getPrice());
        super.pstmt.setDouble(6,storageApplyDetails.getWeight());
        return super.pstmt.executeUpdate() > 0;
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

    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }
}
