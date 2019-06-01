package com.yootk.drp.dao.distribution_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Distribution;

import java.sql.SQLException;

public interface IDistributionDAO extends IBaseDAO<Long,Distribution> {
    /**
     * 取得最后一次增长后的出库表id；
     * @return
     * @throws SQLException
     */
    public Long findLastId() throws SQLException;
}
