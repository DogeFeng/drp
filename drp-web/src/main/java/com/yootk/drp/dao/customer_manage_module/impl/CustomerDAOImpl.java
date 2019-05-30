package com.yootk.drp.dao.customer_manage_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.customer_manage_module.ICustomerDAO;
import com.yootk.drp.vo.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerDAOImpl extends AbstractDAO implements ICustomerDAO {
    @Override
    public boolean doCreate(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Customer findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT cuid,name,phone,address,ciid,indate,connum,recorder FROM customer WHERE status>0 LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        List<Customer> list = new ArrayList<>() ;
        while(rs.next()){
            list.add(super.handleResultToVO(rs,Customer.class)) ;
        }
        return list ;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT cuid,name,phone,address,ciid,indate,connum,recorder FROM customer WHERE status>0 AND " + column + " LIKE? LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery() ;
        List<Customer> list = new ArrayList<>() ;
        while(rs.next()){
            list.add(super.handleResultToVO(rs,Customer.class)) ;
        }
        return list ;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("customer");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("customer",column,keyWord);
    }
}
