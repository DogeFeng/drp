package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.drp.service.back.IGoodsServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Goods;

/**
 * @Auther: LL
 * @Date: 2019/5/28 16:13
 * @Description:
 */
@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsActionBack extends AbstractAction {
    @Autowired
    private IGoodsServiceBack goodsServiceBack ;

    @RequestMapping("goods_add_pre")
    public ModuleAndView addPre() {
        ModuleAndView mav = new ModuleAndView("goods_add.jsp") ;
        try {
            mav.add(goodsServiceBack.addPre());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("goods_add")
    public ModuleAndView add(Goods goods, MultipartFile photo){
        goods.setRecorder("xxx");
        try {
            String fileName = UploadFileToServer.upload(photo,photo.getContentType()) ;
            goods.setPhoto(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            System.out.println(goods);
            if(this.goodsServiceBack.add(goods)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"商品增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"pages/back/admin/goods/goods_add_pre.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"商品增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"pages/back/admin/goods/goods_add_pre.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"pages/back/admin/goods/goods_add_pre.action");
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/goods/";
    }
}
