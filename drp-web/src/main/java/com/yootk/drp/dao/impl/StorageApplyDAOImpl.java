package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IStorageApplyDAO;
import com.yootk.drp.vo.StorageApply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class StorageApplyDAOImpl extends AbstractDAO implements IStorageApplyDAO {
    @Override
    public boolean doCreate(StorageApply storageApply) throws SQLException {
        String sql = "INSERT INTO storage_apply(title,pid,cid,wiid,wid,note)VALUES(?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, storageApply.getTitle());
        super.pstmt.setLong(2, storageApply.getPid());
        super.pstmt.setLong(3, storageApply.getCid());
        super.pstmt.setLong(4, storageApply.getWiid());
        super.pstmt.setLong(5, storageApply.getWid());
        super.pstmt.setString(6, storageApply.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(StorageApply storageApply) throws SQLException {
        String sql = "UPDATE storage_apply SET title=?,pid=?,cid=?,wiid=?,wid=?,note=? WHERE said=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, storageApply.getTitle());
        super.pstmt.setLong(2, storageApply.getPid());
        super.pstmt.setLong(3, storageApply.getCid());
        super.pstmt.setLong(4, storageApply.getWiid());
        super.pstmt.setLong(5, storageApply.getWid());
        super.pstmt.setString(6, storageApply.getNote());
        super.pstmt.setLong(7, storageApply.getSaid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public StorageApply findById(Long aLong) throws SQLException {
        String sql = "SELECT said,title,pid,cid,wiid,wid,note FROM storage_apply WHERE said=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(), StorageApply.class);
    }

    @Override
    public List<StorageApply> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<StorageApply> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = " SELECT said,title,pid,cid,wiid,wid,note,appmid FROM storage_apply " +
                " WHERE status=0 AND LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), StorageApply.class);
    }

    @Override
    public List<StorageApply> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<StorageApply> findSplitByStorageApply(Long said, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT said,title,pid,cid,wiid,wid,note,appmid FROM storage_apply " +
                " WHERE said=? AND status=0 AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setLong(2, said);
        return super.handleResultToList(super.pstmt.executeQuery(), StorageApply.class);
    }

    @Override
    public List<StorageApply> findSplitByStorageApply(Long said, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT said,title,pid,cid,wiid,wid,note,appmid FROM storage_apply " +
                " WHERE said=? AND status=0  LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, said);
        return super.handleResultToList(super.pstmt.executeQuery(), StorageApply.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM storage_apply WHERE status=0";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = " SELECT COUNT(*) FROM storage_apply WHERE status=0 AND" + column + " LIKE ? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }
}
