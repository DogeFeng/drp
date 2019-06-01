package com.yootk.drp.dao.customer_manage_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.customer_manage_module.ICustomerRecordDAO;
import com.yootk.drp.vo.CustomerRecord;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerRecordDAOImpl extends AbstractDAO implements ICustomerRecordDAO {
    @Override
    public boolean doCreate(CustomerRecord customerRecord) throws SQLException {
        String sql = "INSERT INTO customer_record (cmid,cdate,criid,cuid,note) VALUES(?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,customerRecord.getCmid());
        super.pstmt.setDate(2,new java.sql.Date(new java.util.Date().getTime()));
        super.pstmt.setLong(3,customerRecord.getCriid());
        super.pstmt.setLong(4,customerRecord.getCuid());
        super.pstmt.setString(5,customerRecord.getNote());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(CustomerRecord customerRecord) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public CustomerRecord findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<CustomerRecord> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<CustomerRecord> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<CustomerRecord> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<CustomerRecord> findAllById(Long cuid,Long currentPage,Integer lineSize) throws SQLException {
        String sql = "SELECT crid,cmid,cdate,criid,cuid,note FROM customer_record WHERE cuid=" + cuid  + " LIMIT " + (currentPage-1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        List<CustomerRecord> list = new ArrayList<>() ;
        while (rs.next()){
            CustomerRecord cr = new CustomerRecord() ;
            cr.setCrid(rs.getLong(1));
            cr.setCmid(rs.getString(2));
            cr.setCdate(rs.getDate(3));
            cr.setCriid(rs.getLong(4));
            cr.setCuid(rs.getLong(5));
            cr.setNote(rs.getString(6));
            list.add(cr) ;
        }
        return list ;
    }
}
