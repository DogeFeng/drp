package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApply;

import java.sql.SQLException;
import java.util.List;

public interface IStorageApplyDAO extends IBaseDAO<Long, StorageApply> {
    public Long findLastId()throws SQLException ;
    public List<StorageApply> findSplitByStorageApply(Long said, Long currentPage, Integer lineSize) throws SQLException ;
    public List<StorageApply> findSplitByStorageApply(Long said, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException ;
}
