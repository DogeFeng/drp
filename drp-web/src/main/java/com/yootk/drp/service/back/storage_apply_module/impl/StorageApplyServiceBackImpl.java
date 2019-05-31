package com.yootk.drp.service.back.storage_apply_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.city_module.ICityDAO;
import com.yootk.drp.dao.province_module.IProvinceDAO;
import com.yootk.drp.dao.storage_apply_details_module.IStorageApplyDetailsDAO;
import com.yootk.drp.dao.storageapply_module.IStorageApplyDAO;
import com.yootk.drp.dao.warehouse_module.IWarehouseDAO;
import com.yootk.drp.dao.witem_module.IWitemDAO;
import com.yootk.drp.service.back.storage_apply_module.IStorageApplyServiceBack;
import com.yootk.drp.vo.Province;
import com.yootk.drp.vo.StorageApply;
import com.yootk.drp.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ICityDAO cityDAO ;
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
    public Map<String, Object> preEdit(Long wid) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        map.put("allProvinces",allProvinces) ;
        map.put("allWitems",allWitems) ;
        map.put("warehouse",this.warehouseDAO.findById(wid)) ;
        map.put("allCitys",this.cityDAO.findAllProvince(this.warehouseDAO.findByPid(wid))) ;
        return map;
    }

    @Override
    public boolean edit(StorageApply apply) throws Exception {
        return this.storageApplyDAO.doEdit(apply);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> map  = new HashMap<>() ;
        map.put("allWitems",this.witemDAO.findAllMap()) ;
        if(this.isEmpty(column,keyWord)){
            map.put("allStorageApplies",this.storageApplyDAO.findSplit(currentPage, lineSize)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount()) ;
        }else{
            map.put("allStorageApplies",this.storageApplyDAO.findSplit(currentPage, lineSize,column,keyWord)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount(column,keyWord)) ;
        }
        return map;
    }
}
