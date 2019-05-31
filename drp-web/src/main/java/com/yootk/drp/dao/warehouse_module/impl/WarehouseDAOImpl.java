package com.yootk.drp.dao.warehouse_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.warehouse_module.IWarehouseDAO;
import com.yootk.drp.vo.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class WarehouseDAOImpl extends AbstractDAO implements IWarehouseDAO {

    @Override
    public boolean doCreate(Warehouse warehouse) throws SQLException {
        String sql ="INSERT INTO warehouse(name,pid,cid,wiid,address,maximum,currnum,photo,note,admin) VALUES(?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,warehouse.getName());
        super.pstmt.setLong(2,warehouse.getPid());
        super.pstmt.setLong(3,warehouse.getCid());
        super.pstmt.setLong(4,warehouse.getWiid());
        super.pstmt.setString(5,warehouse.getAddress());
        super.pstmt.setInt(6,warehouse.getMaximum());
        super.pstmt.setInt(7,warehouse.getCurrnum());
        super.pstmt.setString(8,warehouse.getPhoto());
        super.pstmt.setString(9,warehouse.getNote());
        super.pstmt.setString(10,warehouse.getAdmin());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Warehouse warehouse) throws SQLException {
        String sql ="UPDATE warehouse SET name=?,pid=?,cid=?,wiid=?,address=?,maximum=?,currnum=?,photo=?,note=? WHERE wid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,warehouse.getName());
        super.pstmt.setLong(2,warehouse.getPid());
        super.pstmt.setLong(3,warehouse.getCid());
        super.pstmt.setLong(4,warehouse.getWiid());
        super.pstmt.setString(5,warehouse.getAddress());
        super.pstmt.setInt(6,warehouse.getMaximum());
        super.pstmt.setInt(7,warehouse.getCurrnum());
        super.pstmt.setString(8,warehouse.getPhoto());
        super.pstmt.setString(9,warehouse.getNote());
        super.pstmt.setLong(10,warehouse.getWid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
        String sql = "SELECT wid,name,pid,cid,wiid,address,maximum,currnum,photo,note FROM warehouse WHERE wid=?" ;
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

    @Override
    public Long findByPid(Long wid) throws SQLException {
        String sql = "SELECT pid FROM warehouse WHERE wid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,wid);
        ResultSet rs = super.pstmt.executeQuery() ;
        if (rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }
}
