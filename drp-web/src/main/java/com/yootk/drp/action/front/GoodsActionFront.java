package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.front.goods_module.IGoodsServiceFront;

import javax.servlet.http.HttpSession;

/**
 * @Auther: LL
 * @Date: 2019/5/30 10:19
 * @Description:
 */
@Controller
@RequestMapping("/pages/front/goods/")
public class GoodsActionFront extends AbstractAction {
    @Autowired
    private IGoodsServiceFront goodsServiceFront ;

    @RequestMapping("goods_show")
    public ModuleAndView goodsShow(Long gid) {
        ModuleAndView mav = new ModuleAndView("goods_show.jsp") ;
        try {
            mav.add("goods" , goodsServiceFront.get(gid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("goods_list")
    public ModuleAndView findSubtypeIdGoods(Long stid){
        if(stid == null) {
            HttpSession session =  ServletObject.getRequest().getSession() ;
            stid = Long.parseLong(session.getAttribute("stid").toString()) ;
            session.removeAttribute("stid");
        }
        ModuleAndView mav = new ModuleAndView("goods_list.jsp") ;
        PageUtil pu = new PageUtil("pages/front/goods/goods_list.action","商品名称:name|商品单价:price");
        try {
            mav.add(goodsServiceFront.findSubtypeIdGoods(stid,pu.getCurrentPage(),8,pu.getColumn(),pu.getKeyword(),1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    /**
     * 商品首页，分类查询
     * @return
     */
    @RequestMapping("goods_mall_index")
    public ModuleAndView findSubtypeAndWitem(String name){
        ModuleAndView mav = new ModuleAndView("/mall_index.jsp") ;
        try {
            mav.add(goodsServiceFront.findSubtypeAndWitem(name));
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
