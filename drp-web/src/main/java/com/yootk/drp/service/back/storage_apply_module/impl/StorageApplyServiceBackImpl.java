package com.yootk.drp.service.back.storage_apply_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.city_module.ICityDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.dao.province_module.IProvinceDAO;
import com.yootk.drp.dao.storage_apply_details_module.IStorageApplyDetailsDAO;
import com.yootk.drp.dao.storageapply_module.IStorageApplyDAO;
import com.yootk.drp.dao.warehouse_module.IWareHouseDAO;
import com.yootk.drp.dao.witem_module.IWitemDAO;
import com.yootk.drp.service.back.storage_apply_module.IStorageApplyServiceBack;
import com.yootk.drp.vo.*;

import java.util.*;

@Service
public class StorageApplyServiceBackImpl extends AbstractService implements IStorageApplyServiceBack {
    @Autowired
    private IProvinceDAO provinceDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IWareHouseDAO warehouseDAO ;
    @Autowired
    private IStorageApplyDAO storageApplyDAO ;
    @Autowired
    private IStorageApplyDetailsDAO storageApplyDetailsDAO ;
    @Autowired
    private ICityDAO cityDAO ;
    @Autowired
    private IGoodsDAO goodsDAO ;


    @Override
    public boolean detailsAdd(StorageApply apply, Set<Long> gids) throws Exception {
        double price = 0.0 ;
        int num = 0 ;
        String name = null ;
        double weight = 0.0 ;
        List<Goods> allGoods = new ArrayList<>() ;
        for(Goods goods : allGoods){
            price = goods.getPrice() ;
            num = goods.getStornum() ;
            name = goods.getName() ;
            weight = goods.getWeight() ;
        }
        if(this.storageApplyDAO.doCreate(apply)){
            Long said = this.storageApplyDAO.findLastId() ;
            List<StorageApplyDetails> allDetails = new ArrayList<>() ;
            for(Long gid : gids){
                StorageApplyDetails details = new StorageApplyDetails() ;
                details.setSaid(said);
                details.setGid(gid) ;
                details.setName(name);
                details.setNum(num);
                details.setPrice(price);
                details.setWeight(weight);
                allDetails.add(details) ;
            }
           return this.storageApplyDetailsDAO.doCreateBatch(allDetails) ;
        }
        return false;
    }

    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        map.put("allProvinces",allProvinces) ;
        map.put("allWitems",allWitems) ;
        map.put("allWarehouses",this.warehouseDAO.findAll()) ;
        return map;
    }

    @Override
    public boolean add(StorageApply apply) throws Exception {
        return this.storageApplyDAO.doCreate(apply);
    }

    @Override
    public Map<String, Object> preEdit(Long said) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allStorageApply",this.storageApplyDAO.findById(said)) ;
        map.put("allCitys",this.cityDAO.findAllProvince(this.storageApplyDAO.findByPid(said))) ;
        map.put("allWitem",this.witemDAO.findAllMap()) ;
        return map;

    }

    @Override
    public boolean edit(StorageApply apply) throws Exception {
        return this.storageApplyDAO.doEdit(apply);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> map  = new HashMap<>() ;
        if(this.isEmpty(column,keyWord)){
            map.put("allStorageApplies",this.storageApplyDAO.findSplit(currentPage, lineSize)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount()) ;
        }else{
            map.put("allStorageApplies",this.storageApplyDAO.findSplit(currentPage, lineSize,column,keyWord)) ;
            map.put("allRecorders",this.storageApplyDAO.getAllCount(column,keyWord)) ;
        }
        map.put("allWitems",this.witemDAO.findAllMap()) ;
        map.put("allWarehouse",this.warehouseDAO.findAllMapWid()) ;
        return map;
    }

    @Override
    public Map<String, Object> detailsPreAdd(Set<Long> gids) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        List<Goods> allGoods = this.goodsDAO.findAllByGids(gids) ;
        result.put("allGoods",allGoods) ;
        return null;
    }

    @Override
    public Map<String, Object> getDetails(Long said) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        Map<Long,Integer> details = this.storageApplyDetailsDAO.findByStorageapply(said);
        map.put("details",details) ;
        System.out.println(details);
        map.put("allGoods",this.goodsDAO.findAllByGids(details.keySet())) ;
        return map ;
    }
}
