package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.ICityDAO;
import com.yootk.drp.dao.IProvinceDAO;
import com.yootk.drp.dao.IWareHouseDAO;
import com.yootk.drp.dao.IWitemDAO;
import com.yootk.drp.service.back.IWarehouseServiceBack;
import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Province;
import com.yootk.drp.vo.Warehouse;
import com.yootk.drp.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class WarehouseServiceBackImpl extends AbstractService implements IWarehouseServiceBack {
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private IWitemDAO witemDAO;
    @Autowired
    private IWareHouseDAO wareHouseDAO;
    @Autowired
    private ICityDAO cityDAO;
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Province> allProvinces = this.provinceDAO.findAll();
        List<Witem> allWitems = this.witemDAO.findAll();
        map.put("allProvinces",allProvinces);
        map.put("allWitems",allWitems);
        return map;
    }
    @Override
    public boolean add(Warehouse warehouse) throws Exception {
        return this.wareHouseDAO.doCreate(warehouse);
    }

    @Override
    public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if(column == null|| "".equals(column) || keyWord == null || "".equals(keyWord)){
            map.put("allRecorders",this.wareHouseDAO.getAllCount());
            map.put("allWarehouses",this.wareHouseDAO.findSplit(currentPage,lineSize));
        }else{
            map.put("allRecorders",this.wareHouseDAO.getAllCount(column,keyWord));
            map.put("allWarehouses",this.wareHouseDAO.findSplit(currentPage,lineSize,column,keyWord));
        }
        map.put("allWitems",this.witemDAO.findAllMap());
        return map;
    }

    @Override
    public Map<String,Object> get(Long wid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if(wid == null || "".equals(wid)){
            return null;
        }
        map.put("warehouse",this.wareHouseDAO.findById(wid));
        map.put("allCitys",this.cityDAO.findAllByProvince(this.wareHouseDAO.getPid(wid)));
        return map;
    }

    @Override
    public boolean edit(Warehouse vo) throws Exception {
        if(vo.getMaximum() < vo.getCurrnum()){
            return false;
        }
        return this.wareHouseDAO.doEdit(vo);
    }
}
