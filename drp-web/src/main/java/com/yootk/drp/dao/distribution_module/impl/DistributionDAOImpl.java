package com.yootk.drp.dao.distribution_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.vo.Distribution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class DistributionDAOImpl extends AbstractDAO implements IDistributionDAO {
    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }

    @Override
    public List<Distribution> findSplit(Integer status, String column, String keyWord, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT dsid,title,pid,cid,note,gnum,price,status FROM distribution WHERE status=? AND " + column + " LIKE ? LIMIT "
                + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        super.pstmt.setString(2,"%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(),Distribution.class);
    }

    @Override
    public List<Distribution> findSplit(Integer status, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT dsid,title,pid,cid,note,gnum,price,status FROM distribution WHERE status=? LIMIT "
                + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        return super.handleResultToList(super.pstmt.executeQuery(),Distribution.class);
    }

    @Override
    public Long getAllCount(Integer status, String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM distribution WHERE status=? AND " + column + " LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        super.pstmt.setString(2,"%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public Long getAllCount(Integer status) throws SQLException {
        String sql = "SELECT COUNT(*) FROM distribution WHERE status=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public boolean doUpdateStatus(Distribution vo) throws SQLException {
        String sql = "UPDATE distribution SET status = ? WHERE dsid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getStatus());
        super.pstmt.setLong(2,vo.getDsid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doCreate(Distribution vo) throws SQLException {
        String sql = "INSERT INTO distribution(title,pid,cid,note,gnum,price,status) VALUES(?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setLong(2,vo.getPid());
        super.pstmt.setLong(3,vo.getCid());
        super.pstmt.setString(4,vo.getNote());
        super.pstmt.setInt(5,vo.getGnum());
        super.pstmt.setDouble(6,vo.getPrice());
        super.pstmt.setInt(7,vo.getStatus());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Distribution vo) throws SQLException {
        String sql = "UPDATE distribution SET title=?,pid=?,cid=?,note=? WHERE dsid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setLong(2,vo.getPid());
        super.pstmt.setLong(3,vo.getCid());
        super.pstmt.setString(4,vo.getNote());
        super.pstmt.setLong(5,vo.getDsid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution findById(Long aLong) throws SQLException {
       String sql = "SELECT dsid,title,pid,cid,gnum,price,status,note FROM distribution WHERE dsid=?";
       super.pstmt = super.conn.prepareStatement(sql);
       super.pstmt.setLong(1,aLong);
       return super.handleResultToVO(super.pstmt.executeQuery(),Distribution.class);
    }

    @Override
    public List<Distribution> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
