package com.yootk.drp.service.back.warehouse_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
<<<<<<< HEAD
import com.yootk.drp.dao.warehouse_module.ICityDAO;
import com.yootk.drp.dao.warehouse_module.IProvinceDAO;
import com.yootk.drp.dao.warehouse_module.IWareHouseDAO;
import com.yootk.drp.dao.warehouse_module.IWitemDAO;
=======
import com.yootk.drp.dao.city_module.ICityDAO;
import com.yootk.drp.dao.province_module.IProvinceDAO;
import com.yootk.drp.dao.warehouse_module.IWarehouseDAO;
import com.yootk.drp.dao.witem_module.IWitemDAO;
>>>>>>> 231dad6d6a9d78fd649045199b527270b2fdbbfb
import com.yootk.drp.service.back.warehouse_module.IWarehouseServiceBack;
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
<<<<<<< HEAD
    private IWareHouseDAO wareHouseDAO;
=======
    private IWarehouseDAO wareHouseDAO;
>>>>>>> 231dad6d6a9d78fd649045199b527270b2fdbbfb
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
<<<<<<< HEAD
        map.put("allCitys",this.cityDAO.findAllByProvince(this.wareHouseDAO.getPid(wid)));
=======
        map.put("allCitys",this.cityDAO.findAllProvince(this.wareHouseDAO.getPid(wid)));
>>>>>>> 231dad6d6a9d78fd649045199b527270b2fdbbfb
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
