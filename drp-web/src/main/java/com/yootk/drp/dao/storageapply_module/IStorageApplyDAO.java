package com.yootk.drp.dao.storageapply_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApply;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IStorageApplyDAO extends IBaseDAO<Long, StorageApply> {
    public Long findLastId()throws SQLException ;

    /**
     * 根据入库清单编号查找省份编号
     * @param said 入库清单的编号
     * @return 查找成功返回该对应的省份编号，否则返回null
     * @throws SQLException SQL
     */
    public Long findByPid(Long said)throws SQLException ;

}
