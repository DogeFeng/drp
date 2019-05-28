package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.vo.Province;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class ProvinceDAOImpl extends AbstractDAO implements IProvinceDAO {

    @Override
    public boolean doCreate(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Province findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Province> findAll() throws SQLException {
        String sql = "SELECT pid,title FROM province";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Province.class);
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
