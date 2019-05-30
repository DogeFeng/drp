package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.drp.service.back.distribution_module.IDistribution_detailsService;
import com.yootk.drp.vo.Distribution_details;

@Controller
@RequestMapping("/pages/back/admin/distribution/")
public class DistributionActionBack extends AbstractAction {
    @Autowired
    private IDistribution_detailsService distribution_detailsService;
    @RequestMapping("distribution_goods_list")
    public void add(Distribution_details vo){  //增加的时候只需要商品编号
        vo.setOutmid("yootk10");
        try {
            super.print(this.distribution_detailsService.add(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getUploadDir() {
        return null;
    }
}
