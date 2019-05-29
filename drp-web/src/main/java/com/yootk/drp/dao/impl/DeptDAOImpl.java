package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.vo.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {
    @Override
    public boolean doCreate(Dept dept) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Dept dept) throws SQLException {
        String sql = "UPDATE dept SET dname=? WHERE did=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,dept.getDname());
        super.pstmt.setLong(2,dept.getDid());
        return super.pstmt.execute();
    }

    @Override
    public boolean doRemove(Set<Integer> integers) throws SQLException {
        return false;
    }

    @Override
    public Dept findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        String sql = "SELECT did,dname,mid FROM dept" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToList(super.pstmt.executeQuery(),Dept.class) ;
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Map<Long, String> findAllMap() throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        Map<Long,String> map = new HashMap<>() ;
        String sql = "SELECT did,dname FROM dept" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        while(rs.next()){
            map.put(rs.getLong(1),rs.getString(2)) ;
        }
        return map ;
    }
}
