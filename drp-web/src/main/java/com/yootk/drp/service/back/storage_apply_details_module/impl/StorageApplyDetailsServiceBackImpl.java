package com.yootk.drp.service.back.storage_apply_details_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.storage_apply_details_module.IStorageApplyDetailsDAO;
import com.yootk.drp.service.back.storage_apply_details_module.IStorageApplyDetailsServiceBack;
import com.yootk.drp.vo.StorageApplyDetails;
@Service
public class StorageApplyDetailsServiceBackImpl extends AbstractService implements IStorageApplyDetailsServiceBack {
    @Autowired
    private IStorageApplyDetailsDAO storageApplyDetailsDAO ;
    @Override
    public boolean add(StorageApplyDetails storageApplyDetails) throws Exception {
        return this.storageApplyDetailsDAO.doCreate(storageApplyDetails) ;
    }
}
