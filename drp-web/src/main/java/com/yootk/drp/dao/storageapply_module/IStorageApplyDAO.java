package com.yootk.drp.dao.storageapply_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApply;

import java.sql.SQLException;
import java.util.List;

public interface IStorageApplyDAO extends IBaseDAO<Long, StorageApply> {
    public Long findLastId()throws SQLException ;
}
