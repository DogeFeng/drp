package com.yootk.drp.service.back.distribution_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.service.back.distribution_module.IDistribution_detailsService;
import com.yootk.drp.vo.Distribution_details;
import com.yootk.drp.vo.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class Distribution_detailsServiceImpl extends AbstractService implements IDistribution_detailsService {
    @Autowired
    private IDistribution_detailsDAO distribution_detailsDAO;
    @Autowired
    private IGoodsDAO goodsDAO;
    @Override
    public boolean add(Distribution_details vo) throws Exception {
        Integer num = this.distribution_detailsDAO.findByGid(vo.getGid());
        if(num == null){  //此时还有没有购物数据
            vo.setNum(1);
            return this.distribution_detailsDAO.doCreateByGid(vo);
        }else{
            num ++;
            vo.setNum(num);
            return this.distribution_detailsDAO.doEditByGid(vo);
        }
    }

    @Override
    public Map<String, Object> listByMid(String mid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Map<Long,Integer> details = this.distribution_detailsDAO.findAllByMid(mid);
        map.put("allGoods",this.goodsDAO.findAllByGids(details.keySet()));
        map.put("details",details);
        return map;
    }

    @Override
    public boolean editBatch(List<Distribution_details> details) throws Exception {
        if(details == null || details.size() == 0){
            return false;
        }
        return this.distribution_detailsDAO.doEditBatch(details);
    }

    @Override
    public boolean deleteByMidAndGid(String mid, Set<Long> gids) throws Exception {
        if(gids == null || gids.size() == 0){
            return false;
        }
        return this.distribution_detailsDAO.doRemoveByMidAndGid(mid,gids);
    }
}
