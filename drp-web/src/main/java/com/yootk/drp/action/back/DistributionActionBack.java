package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.back.distribution_module.IDistributionService;
import com.yootk.drp.service.back.distribution_module.IDistribution_detailsService;
import com.yootk.drp.service.back.warehouse_module.ICityService;
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
    @Autowired
    private ICityService cityService;
    @RequestMapping("distribution_goods_list")
    public void add(Distribution_details vo){  //增加的时候只需要商品编号
        if(super.getFrontUser() == null){
            vo.setOutmid("yootk10");
        }else{
            vo.setOutmid(super.getFrontUser());
        }
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
            String mid = null;
            if(super.getFrontUser() == null){
                mid = "yootk10";
            }else{
                mid = super.getFrontUser();
            }
            Map<String,Object> map = this.distribution_detailsService.listByMid(mid);
            mav.add(map);  //直接将map属性设置到request属性之中
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_details_edit")
    public void edit(String data){
        try{
        String results[] =  data.split(";");
        List<Distribution_details> details = new ArrayList<>();
        String mid = null;
        if(super.getFrontUser() == null){
            mid = "yootk10";
        }else{
            mid = super.getFrontUser();
        }
        for(String result : results){
            String gid = result.split(":")[0];
            String num = result.split(":")[1];
            Distribution_details detail = new Distribution_details();
            detail.setGid(Long.parseLong(gid));
            detail.setNum(Integer.parseInt(num));
            detail.setOutmid(mid);
            details.add(detail);
        }
            super.print(this.distribution_detailsService.editBatch(details));
        } catch (Exception e) {
            super.print(false);
        }
    }
    @RequestMapping("distribution_details_delete")
    public void delete(String data){
        Set<Long> gids = new HashSet<>();
        String results[] = data.split(";");
        String mid = null;
        if(super.getFrontUser() == null){
            mid = "yootk10";
        }else{
            mid = super.getFrontUser();
        }
        for(String gid : results){
            gids.add(Long.parseLong(gid));  //添加所有商品编号
        }
        try {
            super.print(this.distribution_detailsService.deleteByMidAndGid(mid,gids));
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
        String mid = null;
        if(super.getFrontUser() == null){
            mid = "yootk10";
        }else{
            mid = super.getFrontUser();
        }
        try {
            mav.add(this.distributionService.preAdd(mid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_add")
    public ModuleAndView add(Distribution vo){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        String mid = null;
        if(super.getFrontUser() == null){
            mid = "yootk10";
        }else{
            mid = super.getFrontUser();
        }
        try {
            if(this.distributionService.add(mid,vo)){
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
    @RequestMapping("distribution_list_yes")
    public ModuleAndView listStatusYes(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_list_myself_yes.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/distribution/distribution_list_yes.action","申请标题:title|");
        try {
            mav.add(this.distributionService.list(1,pu.getColumn(),pu.getKeyword(),pu.getCurrentPage(),pu.getLineSize()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_list_no")
    public ModuleAndView listStatusNo(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_list_myself_no.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/distribution/distribution_list_no.action","申请标题:title|");
        try {
            mav.add(this.distributionService.list(0,pu.getColumn(),pu.getKeyword(),pu.getCurrentPage(),pu.getLineSize()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_list_details")
    public ModuleAndView listDetails(Long dsid){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_list_details.jsp");
        try {
            Map<String,Object> map = this.distributionService.listDetails(dsid);
            mav.add(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_editStatus")
    public ModuleAndView editStatus(Distribution vo){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            if(vo.getStatus() == 0){
                if(this.distributionService.editStatus(vo)){
                    mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"取消申请成功！");
                    mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_yes.action");
                }else{
                    mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"取消申请失败！");
                    mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_yes.action");
                }
            }else{
                if(this.distributionService.editStatus(vo)){
                    mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"申请出库成功！");
                    mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_no.action");
                }else{
                    mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"申请出库失败！");
                    mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_no.action");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/index.jsp");
        }
        return mav;
    }

    @RequestMapping("distribution_edit_pre")
    public ModuleAndView editPre(Long dsid){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_edit.jsp");
        try {
            mav.add(this.distributionService.preEdit(dsid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("distribution_edit")
    public ModuleAndView edit(Distribution vo){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            if(this.distributionService.edit(vo)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"出库单修改成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_yes.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"出库单修改失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_yes.action");
            }
        } catch (Exception e) {
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"出库单修改失败！");
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/distribution/distribution_list_yes.action");
        }
        return mav;
    }
}
