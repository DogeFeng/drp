package com.yootk.drp.service.back.storage_apply_details_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.StorageApplyDetails;

import java.util.Map;

public interface IStorageApplyDetailsServiceBack {

    /**
     * 实现入库的商品追加操作
     * @param storageApplyDetails  入库商品对象
     * @return 入库成功返回true，否则返回false
     * @throws Exception SQL
     */
    public boolean add(StorageApplyDetails storageApplyDetails)throws Exception ;
}
