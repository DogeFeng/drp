package com.yootk.drp.dao.distribution_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<Long, Integer> findAllByMid(String mid) throws SQLException {
        Map<Long,Integer> map = new HashMap<>();
        String sql = "SELECT gid,num FROM distribution_details WHERE outmid = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            map.put(rs.getLong(1),rs.getInt(2));
        }
        return map;
    }

    @Override
    public boolean doEditBatch(List<Distribution_details> details) throws SQLException {
        String sql = "UPDATE distribution_details SET num=? WHERE outmid=? AND gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        for(Distribution_details detail : details){
            super.pstmt.setInt(1, detail.getNum());
            super.pstmt.setString(2,detail.getOutmid());
            super.pstmt.setLong(3,detail.getGid());
            super.pstmt.addBatch();
        }
        return super.isBatchSuccess(super.pstmt.executeBatch());  //执行批处理
    }

    @Override
    public boolean doRemoveByMidAndGid(String mid, Set<Long> gids) throws SQLException {
        StringBuffer sql = new StringBuffer("DELETE FROM distribution_details WHERE outmid=? AND gid IN (");
        for(Long gid : gids){
            sql.append(gid + ",");
        }
        sql.delete(sql.length() - 1 ,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() > 0;
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
