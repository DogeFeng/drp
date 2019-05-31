package com.yootk.drp.dao.storage_apply_details_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.sql.SQLException;
import java.util.Map;

public interface IStorageApplyDetailsDAO extends IBaseDAO<Long, StorageApplyDetails> {
    public Map<Long,Integer> findAllByStorageApply(Long wid)throws SQLException ;
    public Long findLastId() throws SQLException ;
}
