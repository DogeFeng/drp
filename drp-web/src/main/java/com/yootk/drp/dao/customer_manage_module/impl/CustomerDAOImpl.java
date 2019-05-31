package com.yootk.drp.dao.customer_manage_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.customer_manage_module.ICustomerDAO;
import com.yootk.drp.vo.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CustomerDAOImpl extends AbstractDAO implements ICustomerDAO {
    @Override
    public boolean doCreate(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (name,phone,pid,cid,address,indate,ciid,csid,note,recorder,status) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,customer.getName());
        super.pstmt.setString(2,customer.getPhone());
        super.pstmt.setLong(3,customer.getPid());
        super.pstmt.setLong(4,customer.getCid());
        super.pstmt.setString(5,customer.getAddress());
        super.pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
        super.pstmt.setLong(7,customer.getCiid());
        super.pstmt.setLong(8,customer.getCsid());
        super.pstmt.setString(9,customer.getNote());
        super.pstmt.setString(10,customer.getRecorder());
        super.pstmt.setInt(11,customer.getStatus());
        return super.pstmt.executeUpdate() > 0 ;
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
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, Set<Integer> status) throws SQLException {
        StringBuffer sql = new StringBuffer() ;
        sql.append("SELECT cuid,name,phone,address,ciid,indate,connum,recorder FROM customer WHERE status IN (");
        status.forEach((s)->{
            sql.append("?,") ;
        });
        sql.delete(sql.length() - 1,sql.length()).append(") LIMIT ").append( (currentPage - 1) * lineSize ).append( ", " ).append(lineSize) ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        Iterator<Integer> iter = status.iterator() ;
        int foot = 1 ;
        while(iter.hasNext()){
            super.pstmt.setInt(foot ++,iter.next());
        }
        ResultSet rs = super.pstmt.executeQuery() ;
        List<Customer> list = new ArrayList<>() ;
        while(rs.next()){
            Customer customer = new Customer() ;
            customer.setCuid(rs.getLong(1));
            customer.setName(rs.getString(2));
            customer.setPhone(rs.getString(3));
            customer.setAddress(rs.getString(4));
            customer.setCiid(rs.getLong(5));
            customer.setIndate(rs.getDate(6));
            customer.setConnum(rs.getInt(7));
            customer.setRecorder(rs.getString(8));
            list.add(customer) ;
        }
        return list ;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord, Set<Integer> status) throws SQLException {
        StringBuffer sql = new StringBuffer() ;
        sql.append("SELECT cuid,name,phone,address,ciid,indate,connum,recorder FROM customer WHERE status IN (");
        status.forEach((s)->{
            sql.append("?,") ;
        }); ;
        sql.delete(sql.length() - 1,sql.length()).append(") AND " + column + " LIKE? LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize) ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        Iterator<Integer> iter = status.iterator() ;
        int foot = 1 ;
        while(iter.hasNext()){
            super.pstmt.setInt(foot ++,iter.next());
        }
        super.pstmt.setString(foot ,"%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery() ;
        List<Customer> list = new ArrayList<>() ;
        while(rs.next()){
            Customer customer = new Customer() ;
            customer.setCuid(rs.getLong(1));
            customer.setName(rs.getString(2));
            customer.setPhone(rs.getString(3));
            customer.setAddress(rs.getString(4));
            customer.setCiid(rs.getLong(5));
            customer.setIndate(rs.getDate(6));
            customer.setConnum(rs.getInt(7));
            customer.setRecorder(rs.getString(8));
            list.add(customer) ;
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
