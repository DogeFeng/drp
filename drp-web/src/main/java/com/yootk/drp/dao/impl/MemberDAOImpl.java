package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {

	@Override
	public boolean doCreate(Member member) throws SQLException {
		String sql = "insert into member set mid=?,lid=?,did=?,name=?,sal=?,phone=?,password=?,photo=?,note=?,regdate=?,inmid=?,type=?,email=?,cuid=? FROM member" ;

		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1,member.getMid());
		super.pstmt.setLong(2,member.getLid());
		super.pstmt.setLong(3,member.getDid());
		super.pstmt.setString(4,member.getName());
		super.pstmt.setDouble(5,member.getSal());
		super.pstmt.setString(6,member.getPhone());
		super.pstmt.setString(7,member.getPassword());
		super.pstmt.setString(8,member.getPhoto());
		super.pstmt.setString(9,member.getNote());
		super.pstmt.setDate(10,new java.sql.Date(member.getRegdate().getTime()));
		super.pstmt.setString(11,member.getInmid());
		super.pstmt.setInt(12,member.getType());
		super.pstmt.setString(13,member.getEmail());
		super.pstmt.setLong(14,member.getLid());

		return super.pstmt.executeUpdate(sql)>0;
	}

	@Override
	public boolean doEdit(Member member) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<String> longs) throws SQLException {
		return false;
	}

	@Override
	public Member findById(String id) throws SQLException {
		Member vo = null;
		String sql = "SELECT mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,type,email,cuid FROM member WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Member() ;
			vo.setMid(rs.getString(1));
			vo.setLid(rs.getLong(2));
			vo.setDid(rs.getLong(3));
			vo.setName(rs.getString(4));
			vo.setSal(rs.getDouble(5));
			vo.setPhone(rs.getString(6));
			vo.setPassword(rs.getString(7));
			vo.setPhoto(rs.getString(8));
			vo.setNote(rs.getString(9));
			vo.setRegdate(rs.getDate(10));
			vo.setInmid(rs.getString(11));
			vo.setType(rs.getInt(12));
			vo.setEmail(rs.getString(13));
			vo.setCuid(rs.getLong(14));
		}
		return vo;
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
