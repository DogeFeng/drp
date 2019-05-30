package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.back.distribution_module.IDistributionService;
import com.yootk.drp.service.back.distribution_module.IDistribution_detailsService;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;

import javax.sql.rowset.serial.SerialBlob;
import java.util.*;

@Controller
@RequestMapping("/pages/back/admin/distribution/")
public class DistributionActionBack extends AbstractAction {
    @Autowired
    private IDistributionService distributionService;
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
    @RequestMapping("distribution_details_goods_list")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_goods_list.jsp");
        try {
            Map<String,Object> map = this.distribution_detailsService.listByMid("yootk10");
            mav.add(map);  //直接将map属性设置到request属性之中
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_details_edit")
    public void edit(String data){
        String results[] =  data.split(";");
        List<Distribution_details> details = new ArrayList<>();
        for(String result : results){
            String gid = result.split(":")[0];
            String num = result.split(":")[1];
            Distribution_details detail = new Distribution_details();
            detail.setGid(Long.parseLong(gid));
            detail.setNum(Integer.parseInt(num));
            detail.setOutmid("yootk10");
            details.add(detail);
        }
        try {
            super.print(this.distribution_detailsService.editBatch(details));
        } catch (Exception e) {
            super.print(false);
        }
    }
    @RequestMapping("distribution_details_delete")
    public void delete(String data){
        Set<Long> gids = new HashSet<>();
        String results[] = data.split(";");
        for(String gid : results){
            gids.add(Long.parseLong(gid));  //添加所有商品编号
        }
        try {
            super.print(this.distribution_detailsService.deleteByMidAndGid("yootk10",gids));
        } catch (Exception e) {
            super.print(false);
        }
    }
    @Override
    public String getUploadDir() {
        return null;
    }
    @RequestMapping("distribution_add_pre")
    public ModuleAndView addPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_add.jsp");
        try {
            mav.add(this.distributionService.preAdd("yootk10"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_add")
    public ModuleAndView add(Distribution vo){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            if(this.distributionService.add("yootk10",vo)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"商品出库单创建成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/index.jsp");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"仓库增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_details_goods_list.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_details_goods_list.action");
        }
        return mav;
    }
}
