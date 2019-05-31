package com.yootk.drp.dao.goods_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.goods_module.IWitemDAO;
import com.yootk.drp.vo.Witem;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:32
 * @Description:
 */
@Repository
public class WitemDAOImpl extends AbstractDAO implements IWitemDAO {
    @Override
    public boolean doCreate(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Witem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findAll() throws SQLException {
        String sql = "SELECT wiid,title from witem" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        return super.handleResultToList(super.pstmt.executeQuery() ,Witem.class);
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
