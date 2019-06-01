package com.yootk.drp.dao.storage_apply_details_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IStorageApplyDetailsDAO extends IBaseDAO<Long, StorageApplyDetails> {
    public boolean doCreateBatch(List<StorageApplyDetails> allDetails)throws SQLException ;
    public Long findLastId() throws SQLException ;

    /**
     * 根据入库清单编号查询此清单之中所对应的全部商品信息
     * @param said 入库清单编号
     * @return 返回包含有商品编号和数量的Map集合
     * @throws SQLException 数据层异常
     */
    public Map<Long,Integer> findByStorageapply(Long said)throws SQLException ;
}
