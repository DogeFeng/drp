package com.yootk.drp.dao.distribution_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.vo.Distribution;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class DistributionDAOImpl extends AbstractDAO implements IDistributionDAO {

    @Override
    public boolean doCreate(Distribution vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Distribution vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution findById(Long aLong) throws SQLException {
        return null;
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
