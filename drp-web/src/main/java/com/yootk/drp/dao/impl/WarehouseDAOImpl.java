package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IWarehouseDAO;
import com.yootk.drp.vo.Warehouse;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class WarehouseDAOImpl extends AbstractDAO implements IWarehouseDAO {

    @Override
    public boolean doCreate(Warehouse warehouse) throws SQLException {
        String sql ="INSERT INTO warehouse(wid,name,pid,cid,wiid,address,maximum,currnum,photo,note,recorder,admin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,warehouse.getWid());
        super.pstmt.setString(2,warehouse.getName());
        super.pstmt.setLong(3,warehouse.getPid());
        super.pstmt.setLong(4,warehouse.getCid());
        super.pstmt.setLong(5,warehouse.getWiid());
        super.pstmt.setString(6,warehouse.getAddress());
        super.pstmt.setInt(7,warehouse.getMaximum());
        super.pstmt.setInt(8,warehouse.getCurrnum());
        super.pstmt.setString(9,warehouse.getPhoto());
        super.pstmt.setString(10,warehouse.getNote());
        super.pstmt.setString(11,warehouse.getRecorder());
        super.pstmt.setString(12,warehouse.getAdmin());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Warehouse warehouse) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid,address,maximum,currnum,photo,note,recorder,admin FROM wid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid,address,maximum,currnum,photo,note,recorder,admin FROM Warehouse" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToList(super.pstmt.executeQuery(),Warehouse.class);
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
