package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.back.IGoodsServiceBack;
import com.yootk.drp.service.front.IGoodsServiceFront;

/**
 * @Auther: LL
 * @Date: 2019/5/30 10:19
 * @Description:
 */
@Controller
@RequestMapping("/pages/front/admin/goods/")
public class GoodsActionFront extends AbstractAction {
    @Autowired
    private IGoodsServiceFront goodsServiceFront ;

    @RequestMapping("goods_mall_index")
    public ModuleAndView findSubtypeAndWitem(){
        ModuleAndView mav = new ModuleAndView("/mall_index.jsp") ;
        try {
            mav.add(goodsServiceFront.findSubtypeAndWitem());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
