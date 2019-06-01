package com.yootk.drp.dao.goods_module.impl;

import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        return null;
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
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT gid,name,price,weight,stornum FROM goods WHERE IN(") ;
        for(Long gid : gids){
            sql.append(gid).append(",") ;
        }
        sql.delete(sql.length() -1 ,sql.length()).append(")") ;
        List<Goods> all = new ArrayList<>() ;
        super.pstmt = super.conn.prepareStatement(sql.toString()) ;
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }
}
