package com.yootk.drp.dao.storage_apply_details_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.storage_apply_details_module.IStorageApplyDetailsDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository
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
    public boolean doCreateBatch(List<StorageApplyDetails> allDetails) throws SQLException {
        String sql = "INSERT INTO storage_apply_details(said,gid,name,num,price,weight)VALUES(?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        for(StorageApplyDetails details : allDetails){
            super.pstmt.setLong(1,details.getSaid());
            super.pstmt.setLong(2,details.getGid());
            super.pstmt.setString(3,details.getName());
            super.pstmt.setDouble(4,details.getPrice());
            super.pstmt.setDouble(5,details.getWeight());
            super.pstmt.addBatch();
        }
        return super.isBatchSuccess(super.pstmt.executeBatch());
    }

    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }

    @Override
    public Map<Long, Integer> findByStorageapply(Long said) throws SQLException {
        Map<Long,Integer> map = new HashMap<>() ;
        String sql = "SELECT gid,num FROM storage_apply_details WHERE said=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,said) ;
        ResultSet rs  = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getLong(1),rs.getInt(2)) ;
        }
        return map;
    }
}
