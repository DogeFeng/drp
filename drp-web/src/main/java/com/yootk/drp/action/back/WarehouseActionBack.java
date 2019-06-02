package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.warehouse_module.ICityService;
import com.yootk.drp.service.back.warehouse_module.IWarehouseServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Warehouse;

@Controller
@RequestMapping("/pages/back/admin/warehouse/")
public class WarehouseActionBack extends AbstractAction {
    @Autowired
    private IWarehouseServiceBack warehouseServiceBack;
    @Autowired
    private ICityService cityService;
    @RequestMapping("warehouse_add_pre")
    public ModuleAndView addPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/warehouse/warehouse_add.jsp");
        try {
            mav.add(this.warehouseServiceBack.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("warehouse_add_preCity")
    public void addPre(Long pid){
        try {
            super.print(JSONObject.toJSONString(this.cityService.preAddCity(pid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("warehouse_add")
    public ModuleAndView add(Warehouse warehouse,MultipartFile file){
//        warehouse.setAdmin(super.getFrontUser());  //设置仓库管理员的用户编号
        if(super.getFrontUser() == null){
            warehouse.setAdmin("chengcheng");
        }else{
            warehouse.setAdmin(super.getFrontUser());
        }
        try {
            String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
            warehouse.setPhoto(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            if(this.warehouseServiceBack.add(warehouse)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"仓库增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_add_pre.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"仓库增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_add_pre.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_add_pre.action");
        }
        return mav;
    }
    @Override
    public String getUploadDir() {
        return "/upload/warehouse/";
    }
    @RequestMapping("warehouse_list")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/warehouse/warehouse_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/warehouse/warehouse_list.action","选项: |仓库名称:name");
        try {
            mav.add(this.warehouseServiceBack.list(pu.getColumn(),pu.getKeyword(),pu.getCurrentPage(),pu.getLineSize()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("warehouse_edit_pre")
    public ModuleAndView editPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/warehouse/warehouse_edit_show.action");
        try {
            mav.add(this.warehouseServiceBack.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("warehouse_edit_show")
    public ModuleAndView editshow(Long wid){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/warehouse/warehouse_edit.jsp");
        try {
            mav.add(this.warehouseServiceBack.get(wid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("warehouse_edit")
    public ModuleAndView edit(Warehouse warehouse,MultipartFile file){
        try {
            String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
            if(fileName != null || fileName != warehouse.getPhoto()){
                warehouse.setPhoto(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            if(this.warehouseServiceBack.edit(warehouse)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"仓库编辑成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_list.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"仓库编辑失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_edit_pre.action?wid=" + warehouse.getWid());
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/warehouse/warehouse_edit_pre.action?wid=" + warehouse.getWid());
        }
        return mav;
    }
}
