package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.*;
import com.yootk.drp.service.back.IStorageApplyServiceBack;
import com.yootk.drp.vo.Province;
import com.yootk.drp.vo.StorageApply;
import com.yootk.drp.vo.Warehouse;
import com.yootk.drp.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StorageApplyServiceBackImpl extends AbstractService implements IStorageApplyServiceBack {
    @Autowired
    private IProvinceDAO provinceDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Autowired
    private IStorageApplyDAO storageApplyDAO ;
    @Autowired
    private IStorageApplyDetailsDAO storageApplyDetailsDAO ;
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        map.put("allProvinces",allProvinces) ;
        map.put("allWitems",allWitems) ;

        return map;
    }

    @Override
    public boolean add(StorageApply apply) throws Exception {
        return this.storageApplyDAO.doCreate(apply);
    }

    @Override
    public Map<String, Object> preEdit(Long said) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        map.put("allProvinces",allProvinces) ;
        map.put("allWitems",allWitems) ;
        map.put("applies",this.storageApplyDAO.findById(said)) ;
        return map;
    }

    @Override
    public boolean edit(StorageApply apply) throws Exception {
        return this.storageApplyDAO.doEdit(apply);
    }

    @Override
    public Map<String, Object> list(Long said,Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> map  = new HashMap<>() ;
        if(this.isEmpty(column,keyWord)){
            map.put("allStorageApplies",this.storageApplyDAO.findSplitByStorageApply(said,currentPage, lineSize)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount()) ;
        }else{
            map.put("allStorageApplies",this.storageApplyDAO.findSplitByStorageApply(said,currentPage, lineSize,column,keyWord)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount(column,keyWord)) ;
        }
        return map;
    }
    @Override
    public Map<String, Object> getDetails(Long sadid) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("storageApply",this.storageApplyDAO.findById(sadid)) ;
        Map<Long,Integer> detials = this.storageApplyDetailsDAO.findAllByStorageApply(sadid) ;
        map.put("detials",detials) ;
        return map;
    }
}
