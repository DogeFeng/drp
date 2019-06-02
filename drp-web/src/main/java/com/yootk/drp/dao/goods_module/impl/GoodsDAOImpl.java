package com.yootk.drp.dao.goods_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.vo.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:50
 * @Description:
 */
@Repository
public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        String sql = "INSERT INTO goods(name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag) VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1 , goods.getName());
        super.pstmt.setLong(2 , goods.getWiid());
        super.pstmt.setLong(3 , goods.getStid());
        super.pstmt.setDouble(4 , goods.getPrice());
        super.pstmt.setDouble(5 , goods.getWeight());
        super.pstmt.setString(6 , goods.getPhoto());
        super.pstmt.setString(7, goods.getNote());
        super.pstmt.setDate(8 , new java.sql.Date(goods.getLastin().getTime()));
        super.pstmt.setInt(9, goods.getStornum());
        super.pstmt.setString(10 , goods.getRecorder());
        super.pstmt.setInt(11 , goods.getDelflag());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        String sql = "UPDATE goods SET name=?,wiid=?,stid=?,price=?,weight=?,photo=?,note=?,lastin=?,stornum=?,recorder=?,delflag=? WHERE gid=? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1 , goods.getName());
        super.pstmt.setLong(2 , goods.getWiid());
        super.pstmt.setLong(3 , goods.getStid());
        super.pstmt.setDouble(4 , goods.getPrice());
        super.pstmt.setDouble(5 , goods.getWeight());
        super.pstmt.setString(6 , goods.getPhoto());
        super.pstmt.setString(7, goods.getNote());
        super.pstmt.setDate(8 , new java.sql.Date(goods.getLastin().getTime()));
        super.pstmt.setInt(9, goods.getStornum());
        super.pstmt.setString(10 , goods.getRecorder());
        super.pstmt.setInt(11 , goods.getDelflag());
        super.pstmt.setLong(12 , goods.getGid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public List<Goods> findLinkName(String name) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE name LIKE ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1 , "%" + name +"%");
        return super.handleResultToList(super.pstmt.executeQuery() , Goods.class);
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE gid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1 , aLong);
        return super.handleResultToVO(super.pstmt.executeQuery() , Goods.class);
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Goods> findAllFlag(int delflag) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE delflag=? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1 , delflag);
        return super.handleResultToList(super.pstmt.executeQuery() , Goods.class);
    }

    @Override
    public List<Goods> findSplitFlag(Long currentPage, Integer lineSize, int delflag) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE delflag=?  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1 , delflag);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplitFlag(Long currentPage, Integer lineSize, String column, String keyWord, int delflag) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE delflag=? AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1 , delflag);
        super.pstmt.setString(2, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public Long getAllCountFlag(int delflag) throws SQLException {
        String sql = "SELECT COUNT(*) FROM goods WHERE delflag=?  " ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1 , delflag);
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public Long getAllCountFlag(String column, String keyWord, int delflag) throws SQLException {
        String sql = "SELECT COUNT(*) FROM goods WHERE delflag=? AND " + column + " LIKE ?" ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1 , delflag);
        this.pstmt.setString(2,"%"+keyWord+"%");
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public Long getAllCountFlagAndStid(Long stid, String column, String keyWord, int delflag) throws SQLException {
        String sql = "SELECT COUNT(*) FROM goods WHERE stid =? AND delflag=? AND " + column + " LIKE ?" ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1 , stid);
        super.pstmt.setInt(2 , delflag);
        this.pstmt.setString(3,"%"+keyWord+"%");
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public Long getAllCountFlagAndStid(Long stid, int delflag) throws SQLException {
        String sql = "SELECT COUNT(*) FROM goods WHERE stid =? AND delflag=?  " ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1 , stid);
        super.pstmt.setInt(2 , delflag);
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public List<Goods> findSplitFlagAndStid(Long stid, Long currentPage, Integer lineSize, String column, String keyWord, int delflag) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE stid =? AND delflag=? AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1 , stid);
        super.pstmt.setInt(2 , delflag);
        super.pstmt.setString(3, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplitFlagAndStid(Long stid, Long currentPage, Integer lineSize, int delflag) throws SQLException {
        String sql = " SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag FROM goods WHERE stid =? AND delflag=?  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1 , stid);
        super.pstmt.setInt(2 , delflag);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException {
        if(gids == null || gids.size() == 0){
            return null;
        }
        StringBuffer sql = new StringBuffer("SELECT gid,name,price,photo,stornum FROM goods WHERE gid IN(");
        for(Long gid : gids){
            sql.append(gid + ",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public boolean doUpdateBatch(List<Goods> updateGoods) throws SQLException {
        String sql = "UPDATE goods SET stornum=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        for(Goods good : updateGoods){
            super.pstmt.setInt(1,good.getStornum());
            super.pstmt.setLong(2,good.getGid());
            super.pstmt.addBatch();
        }
        return super.isBatchSuccess(super.pstmt.executeBatch());
    }
}
