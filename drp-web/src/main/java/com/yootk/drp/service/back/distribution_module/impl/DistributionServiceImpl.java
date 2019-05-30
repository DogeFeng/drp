package com.yootk.drp.service.back.distribution_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.distribution_module.IDistributionDAO;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.dao.warehouse_module.IProvinceDAO;
import com.yootk.drp.service.back.distribution_module.IDistributionService;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Province;

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
    @Override
    public Map<String, Object> preAdd(String mid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Set<Long> gids = this.distribution_detailsDAO.getAllGids(mid);  //所有的商品编号
        Map<Long,Integer> details = this.distribution_detailsDAO.findAllByMid(mid);  //所有的详情信息
        List<Goods> allGoods = this.goodsDAO.findAllByGids(gids); //所有的商品信息
        List<Province> allProvinces = this.provinceDAO.findAll();  //列出所有的省份信息
        map.put("details",details);
        map.put("allGoods",allGoods);
        map.put("allProvinces",allProvinces);
        return map;
    }

    @Override
    public boolean add(String mid, Distribution vo) throws Exception {
        Set<Long> gids = this.distribution_detailsDAO.getAllGids(mid);  //所有的商品编号
        List<Goods> allGoods = this.goodsDAO.findAllByGids(gids); //所有的商品信息
        Map<Long,Integer> details = this.distribution_detailsDAO.findAllByMid(mid);  //所有的详情信息
        double sum = 0.0;
        int gnum = 0;
        for(Goods good : allGoods){
            sum += good.getPrice() * details.get(good.getGid());
            gnum += details.get(good.getGid());
        }
        vo.setGnum(gnum);
        vo.setPrice(sum);
        vo.setStatus(1);
        if(this.distributionDAO.doCreate(vo)){
            Long dsid = this.distributionDAO.findLastId();
            if(this.distribution_detailsDAO.doCreateBatch(allGoods,1,dsid)){
                return true;
            }
        }
        return false;
    }
}
