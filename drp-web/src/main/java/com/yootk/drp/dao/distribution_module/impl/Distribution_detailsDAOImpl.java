package com.yootk.drp.dao.distribution_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;
import com.yootk.drp.vo.Goods;

import java.rmi.server.RemoteServer;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class Distribution_detailsDAOImpl extends AbstractDAO implements IDistribution_detailsDAO {
    @Override
    public boolean doUpdateBatch(List<Goods> allGoods,Integer status,Long dsid) throws SQLException {
        String sql = "UPDATE distribution_details SET name=?,price=?,status=?,dsid=? WHERE gid=? AND dsid IS NULL";
        super.pstmt = super.conn.prepareStatement(sql);
        for(Goods good : allGoods){
            super.pstmt.setString(1,good.getName());
            super.pstmt.setDouble(2,good.getPrice());
            super.pstmt.setInt(3,status);
            super.pstmt.setLong(4,dsid);
            super.pstmt.setLong(5,good.getGid());
            super.pstmt.addBatch();
        }
        return super.isBatchSuccess(super.pstmt.executeBatch());
    }

    @Override
    public List<Distribution_details> findAllByDsid(Long dsid) throws SQLException {
        String sql = "SELECT dsdid,dsid,gid,name,num,price,status,wid,outmid FROM distribution_details WHERE dsid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,dsid);
        return super.handleResultToList(super.pstmt.executeQuery(),Distribution_details.class);
    }

    @Override
    public boolean doCreateByGid(Distribution_details vo) throws SQLException {
        String sql = "INSERT INTO distribution_details(gid,num,outmid,cuid)VALUES(?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,vo.getGid());
        super.pstmt.setInt(2,vo.getNum());
        super.pstmt.setString(3,vo.getOutmid());
        super.pstmt.setLong(4,vo.getCuid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doCreateByCuid(Distribution_details vo) throws SQLException {
        String sql = "INSERT INTO  distribution_details(cuid,outmid) VALUES (?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,vo.getCuid());
        super.pstmt.setString(2,vo.getOutmid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEditByGid(Distribution_details vo) throws SQLException {
        String sql = "UPDATE distribution_details SET num=? WHERE outmid=? AND gid=? AND dsid IS NULL ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getNum());
        super.pstmt.setString(2,vo.getOutmid());
        super.pstmt.setLong(3,vo.getGid());
        return super.pstmt.executeUpdate() > 0;
    }
    @Override
    public boolean doEditByDsdid(Distribution_details vo) throws SQLException {
        String sql = "UPDATE distribution_details SET num=?,gid=? WHERE outmid=? AND dsdid=? AND dsid IS NULL ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getNum());
        super.pstmt.setLong(2,vo.getGid());
        super.pstmt.setString(3,vo.getOutmid());
        super.pstmt.setLong(4,vo.getDsdid());
        return super.pstmt.executeUpdate() > 0;
    }
    @Override
    public Integer findByGid(Long gid) throws SQLException {
        String sql = "SELECT num FROM distribution_details WHERE gid=? AND dsid IS NULL ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,gid);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return null;
    }

    @Override
    public Distribution_details findByDsdid(String outmid) throws Exception {
        String sql = "SELECT dsdid,dsid,gid,name,num,price,status,wid,outmid,cuid FROM distribution_details WHERE outmid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,outmid);
        return super.handleResultToVO(super.pstmt.executeQuery(),Distribution_details.class);
    }

    @Override
    public Map<Long, Integer> findAllByMid(String mid) throws SQLException {
        Map<Long,Integer> map = new HashMap<>();
        String sql = "SELECT gid,num FROM distribution_details WHERE outmid = ? AND dsid IS NULL ";
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
        String sql = "UPDATE distribution_details SET num=? WHERE outmid=? AND gid=? AND dsid IS NULL";
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
        StringBuffer sql = new StringBuffer("DELETE FROM distribution_details WHERE outmid=? AND dsid IS NULL AND gid IN (");
        for(Long gid : gids){
            sql.append(gid + ",");
        }
        sql.delete(sql.length() - 1 ,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() > 0;
    }

//    @Override
//    public Set<Long> getAllGids(String mid) throws SQLException {
//        Set<Long> gids = new HashSet<>();
//        String sql = "SELECT gid FROM distribution_details WHERE outmid=? AND dsid IS NULL";
//        super.pstmt = super.conn.prepareStatement(sql);
//        super.pstmt.setString(1,mid);
//        ResultSet rs = super.pstmt.executeQuery();
//        while (rs.next()){
//            gids.add(rs.getLong(1));
//        }
//        return gids;
//    }

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
        String sql = "SELECT dsdid,dsid,gid,name,num,price,status,wid,outmid FROM distribution_details WHERE gid=? AND dsid IS NULL";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
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
