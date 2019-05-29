package com.yootk.drp.dao.distribution_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;

import java.sql.SQLException;

public interface IDistribution_detailsDAO extends IBaseDAO<Long, Distribution_details> {
    public boolean doCreateByGid(Distribution_details vo) throws SQLException;
    public boolean doEditByGid(Distribution_details vo) throws SQLException;
    public Integer findByGid(Long gid) throws SQLException;
}
