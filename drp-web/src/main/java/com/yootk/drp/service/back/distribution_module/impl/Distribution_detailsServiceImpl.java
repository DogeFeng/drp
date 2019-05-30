package com.yootk.drp.service.back.distribution_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.distribution_module.IDistribution_detailsDAO;
import com.yootk.drp.service.back.distribution_module.IDistribution_detailsService;
import com.yootk.drp.vo.Distribution_details;
@Service
public class Distribution_detailsServiceImpl extends AbstractService implements IDistribution_detailsService {
    @Autowired
    private IDistribution_detailsDAO distribution_detailsDAO;
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
}
