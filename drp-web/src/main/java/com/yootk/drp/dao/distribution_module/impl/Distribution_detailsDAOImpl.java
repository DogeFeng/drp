package com.yootk.drp.dao.distribution_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class Distribution_detailsDAOImpl extends AbstractDAO implements IDistribution_detailsDAO {
    @Override
    public boolean doCreateByGid(Distribution_details vo) throws SQLException {
        String sql = "INSERT INTO distribution_details(gid,num,outmid)VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,vo.getGid());
        super.pstmt.setInt(2,vo.getNum());
        super.pstmt.setString(3,vo.getOutmid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEditByGid(Distribution_details vo) throws SQLException {
        String sql = "UPDATE distribution_details SET num=?,outmid=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getNum());
        super.pstmt.setString(2,vo.getOutmid());
        super.pstmt.setLong(3,vo.getGid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public Integer findByGid(Long gid) throws SQLException {
        String sql = "SELECT num FROM distribution_details WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,gid);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return null;
    }

    @Override
    public boolean doCreate(Distribution_details distribution_details) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Distribution_details vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution_details findById(Long aLong) throws SQLException {
        String sql = "SELECT dsdid,gid,name,num,price,status,wid,outmid FROM distribution_details WHERE gid=?";
        super.pstmt.setLong(1,aLong);
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToVO(super.pstmt.executeQuery(),Distribution_details.class);
    }

    @Override
    public List<Distribution_details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
