package com.yootk.drp.dao.emp_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.emp_module.IEmpDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class EmpDAOImpl extends AbstractDAO implements IEmpDAO {
    @Override
    public boolean doCreate(Member member) throws SQLException {
        String sql = "INSERT INTO member (mid,lid,did,name,phone,password,photo,note,regdate,inmid,type) " +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,member.getMid());
        super.pstmt.setLong(2,member.getLid());
        super.pstmt.setLong(3,member.getDid());
        super.pstmt.setString(4,member.getName());
        super.pstmt.setString(5,member.getPhone());
        super.pstmt.setString(6,member.getPassword());
        super.pstmt.setString(7,member.getPhoto());
        super.pstmt.setString(8,member.getNote());
        super.pstmt.setDate(9, new java.sql.Date(new Date().getTime()));
        super.pstmt.setString(10,member.getInmid());
        super.pstmt.setInt(11,1);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Member member) throws SQLException {
        String sql = "UPDATE member SET lid=?,did=?,name=?,phone=?,password=?,photo=?,note=? WHERE mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,member.getLid());
        super.pstmt.setLong(2,member.getDid());
        super.pstmt.setString(3,member.getName());
        super.pstmt.setString(4,member.getPhone());
        super.pstmt.setString(5,member.getPassword());
        super.pstmt.setString(6,member.getPhoto());
        super.pstmt.setString(7,member.getNote());
        super.pstmt.setString(8,member.getMid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Member findById(String s) throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        String sql = "SELECT mid,lid,did,name,phone,password,photo,note FROM member WHERE mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,s);
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class);
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null ;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null ;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("member");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("member",column,keyWord);
    }

    @Override
    public List<Member> findEmpSplit(Long currentPage, Integer lineSize) throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        List<Member> list = new ArrayList<>() ;
        String sql = "SELECT mid,lid,did,name,sal,phone,photo,regdate FROM member LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        while(rs.next()){
            Member member = new Member() ;
            member.setMid(rs.getString(1));
            member.setLid(rs.getLong(2));
            member.setDid(rs.getLong(3));
            member.setName(rs.getString(4));
            member.setSal(rs.getDouble(5));
            member.setPhone(rs.getString(6));
            member.setPhoto(rs.getString(7));
            member.setRegdate(rs.getDate(8));
            list.add(member) ;
        }
        return list ;
    }

    @Override
    public List<Member> findEmpSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        String sql = "SELECT mid,lid,did,name,sal,phone,photo,regdate FROM member WHERE type=1 AND " + column + " LIKE? LIMIT " + (currentPage - 1) * lineSize + ", " + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery() ;
        List<Member> list = new ArrayList<>() ;
        while(rs.next()){
            Member member = new Member() ;
            member.setMid(rs.getString(1));
            member.setLid(rs.getLong(2));
            member.setDid(rs.getLong(3));
            member.setName(rs.getString(4));
            member.setSal(rs.getDouble(5));
            member.setPhone(rs.getString(6));
            member.setPhoto(rs.getString(7));
            member.setRegdate(rs.getDate(8));
            list.add(member) ;
        }
        return list ;
    }

    @Override
    public Map<String, String> findMembersMapById(List<String> ids) throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        Map<String,String> map = new HashMap<>() ;
        StringBuffer sql = new StringBuffer() ;
        sql.append("SELECT mid,name FROM member WHERE mid IN(") ;
        ids.forEach((id)->{
            sql.append("?,") ;
        }) ;
        sql.delete(sql.length() - 1 , sql.length()).append(")") ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        Iterator<String> iter = ids.iterator();
        int foot = 1 ;
        while(iter.hasNext()){
            super.pstmt.setString(foot,iter.next());
            foot ++ ;
        }
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()){
            map.put(rs.getString(1),rs.getString(2)) ;
        }
        return map ;
    }

    @Override
    public Member findByEmail(String email) throws SQLException {
        String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email " +
                " FROM member WHERE email=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,email);
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class) ;
    }

    @Override
    public Member findByphone(String phone) throws SQLException {
        String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email " +
                " FROM member WHERE phone=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,phone);
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class) ;
    }
}
