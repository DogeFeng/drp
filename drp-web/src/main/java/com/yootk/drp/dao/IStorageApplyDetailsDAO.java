package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.sql.SQLException;
import java.util.Map;

public interface IStorageApplyDetailsDAO extends IBaseDAO<Long, StorageApplyDetails> {
    /**
     * 根据入库编号查询商品信息
     * @param sadid 入库编号
     * @return 返回入库编号和商品数量存储到Map集合中
     * @throws SQLException SQL执行异常
     */
    public Map<Long,Integer> findAllByStorageApply(Long sadid)throws SQLException ;
}
