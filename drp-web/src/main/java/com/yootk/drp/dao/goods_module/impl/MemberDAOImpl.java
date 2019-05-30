package com.yootk.drp.dao.goods_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.goods_module.IMemberDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: LL
 * @Date: 2019/5/28 15:09
 * @Description:
 */
@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
    @Override
    public boolean doCreate(Member member) throws SQLException {
        return false;
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
    public Map<String, String> findMap() throws SQLException {
        String sql = "SELECT mid,name FROM member " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        Map<String,String> map = new HashMap<>() ;
        while (rs.next()) {
            map.put(rs.getString(1) , rs.getString(2)) ;
        }
        return map;
    }

    @Override
    public Member findById(String s) throws SQLException {
        String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid FROM member WHERE mid=? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToVO(super.pstmt.executeQuery(),Member.class);
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
