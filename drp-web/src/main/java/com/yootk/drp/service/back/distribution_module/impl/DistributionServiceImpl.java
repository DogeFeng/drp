package com.yootk.drp.service.back.distribution_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.dao.warehouse_module.ICityDAO;
import com.yootk.drp.dao.warehouse_module.IProvinceDAO;
import com.yootk.drp.service.back.distribution_module.IDistributionService;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Province;
import com.yootk.drp.vo.Warehouse;

import java.util.*;

@Service
public class DistributionServiceImpl extends AbstractService implements IDistributionService {

    @Autowired
    private IDistribution_detailsDAO distribution_detailsDAO;  //查询保存的商品数量
    @Autowired
    private IDistributionDAO distributionDAO;
    @Autowired
    private IGoodsDAO goodsDAO;  //查询商品详细信息
    @Autowired
    private IProvinceDAO provinceDAO; //查询所有省份信息
    @Autowired
    private ICityDAO cityDAO;  //查询所有城市信息，用于回显
    @Override
    public Map<String, Object> preAdd(String mid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Map<Long,Integer> details = this.distribution_detailsDAO.findAllByMid(mid);  //所有的详情信息
        List<Goods> allGoods = this.goodsDAO.findAllByGids(details.keySet()); //所有的商品信息
        List<Province> allProvinces = this.provinceDAO.findAll();  //列出所有的省份信息
        map.put("details",details);
        map.put("allGoods",allGoods);
        map.put("allProvinces",allProvinces);
        return map;
    }

    @Override
    public boolean add(String mid, Distribution vo) throws Exception {
        Set<Long> gids = this.distribution_detailsDAO.findAllByMid(mid).keySet();  //所有的商品编号
        List<Goods> allGoods = this.goodsDAO.findAllByGids(gids); //所有的商品信息
        Map<Long,Integer> details = this.distribution_detailsDAO.findAllByMid(mid);  //所有的详情信息
        double sum = 0.0;  //保存总价
        int gnum = 0;  //保存总量
        for(Goods good : allGoods){
            sum += good.getPrice() * details.get(good.getGid());
            gnum += details.get(good.getGid());
        }
        vo.setGnum(gnum);
        vo.setPrice(sum);
        vo.setStatus(1);
        if(this.distributionDAO.doCreate(vo)){
            Long dsid = this.distributionDAO.findLastId();
            if(this.distribution_detailsDAO.doUpdateBatch(allGoods,1,dsid)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> list(Integer status, String column, String keyWord, Long currentPage, Integer lineSize) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if(column == null || "".equals(column) || keyWord == null || "".equals(keyWord)){
            map.put("allDistribution",this.distributionDAO.findSplit(status,currentPage,lineSize));
            map.put("allRecorders",this.distributionDAO.getAllCount(status));
        }else{
            map.put("allDistribution",this.distributionDAO.findSplit(status,column,keyWord,currentPage,lineSize));
            map.put("allRecorders",this.distributionDAO.getAllCount(status,column,keyWord));
        }
        map.put("allProvinces",this.provinceDAO.findAllMap());
        map.put("allCitys",this.cityDAO.findAllMap());
        return map;
    }

    @Override
    public Map<String, Object> listDetails(Long dsid) throws Exception {
        if(dsid == null){
            return null;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("distribution",this.distributionDAO.findById(dsid));
        map.put("allDists",this.distribution_detailsDAO.findAllByDsid(dsid));
        map.put("allProvinces",this.provinceDAO.findAllMap());
        map.put("allCitys",this.cityDAO.findAllMap());
        return map;
    }

    @Override
    public boolean editStatus(Distribution vo) throws Exception {
        if(vo == null){
            return false;
        }
        return this.distributionDAO.doUpdateStatus(vo);
    }

    @Override
    public Map<String,Object> preEdit(Long dsid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if(dsid == null || "".equals(dsid)){
            return null;
        }
        map.put("dist",this.distributionDAO.findById(dsid));
        map.put("allCitys",this.cityDAO.findAllByProvince(this.distributionDAO.findById(dsid).getPid()));
        map.put("allProvinces",this.provinceDAO.findAll());
        return map;
    }

    @Override
    public boolean edit(Distribution vo) throws Exception {
        return this.distributionDAO.doEdit(vo);
    }
}
