package com.yootk.drp.dao.member_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.member_module.IMemberDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
    @Override
    public boolean doCreate(Member member) throws SQLException {
        String sql = " INSERT INTO member(mid,password) VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, member.getMid());
        super.pstmt.setString(2, member.getPassword());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Member member) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Member findById(String s) throws SQLException {
        String sql = "SELECT mid,password FROM member WHERE mid=? AND type=0";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, s);
        System.out.println("********************************************" + s);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Member vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            return vo;
        }
        return null;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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