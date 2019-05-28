package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.drp.service.back.ICityService;
import com.yootk.drp.service.back.IWarehouseServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Warehouse;

@Controller
@RequestMapping("/pages/back/admin/warehouse/")
public class WarehouseAddPreActionBack extends AbstractAction {
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
        warehouse.setAdmin("chengcheng");
        try {
            String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
            warehouse.setPhoto(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(warehouse);
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
}