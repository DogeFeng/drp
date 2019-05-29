package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.IStorageApplyServiceBack;
import com.yootk.drp.vo.StorageApply;
import com.yootk.drp.vo.Warehouse;

@Controller
@RequestMapping("/pages/back/admin/storage/")
public class StorageApplyActionBack extends AbstractAction {
    @Autowired
    private IStorageApplyServiceBack storageApplyService ;

    /**
     * 创建商品入库的信息列表
     * @param apply 商品入库的信息对象
     * @return 返回创建商品入库的页面
     */
    @RequestMapping("storage_add")
    public ModuleAndView add(StorageApply apply){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        try {
            if (this.storageApplyService.add(apply)) {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_add_pre.action");
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_add_pre.action");
            }
        }catch (Exception e){
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_add_pre.action");
        }
        return mav ;
    }

    /**
     * 显示商品入库信息
     * @return 返回创建页面
     */
    @RequestMapping("storage_add_pre")
    public ModuleAndView addPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_add.jsp") ;
        try {
            mav.add(this.storageApplyService.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_edit_pre")
    public ModuleAndView editPre(Long said){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_edit.jsp") ;
        try {
            mav.add(this.storageApplyService.preEdit(said));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_edit")
    public ModuleAndView edit(StorageApply apply){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        try {
            if (this.storageApplyService.edit(apply)) {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库修改成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_edit_pre.action");
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库修改失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_edit_pre.action");
            }
        }catch (Exception e){
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_edit_pre.action");
        }
        return mav ;
    }
    @RequestMapping("storage_details_show")
    public ModuleAndView show(Long sadid){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_details.jsp") ;
        try {
            mav.add(this.storageApplyService.getDetails(sadid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_list")
    public ModuleAndView list(Long said)throws Exception{
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_myself.jsp") ;
        PageUtil pu = new PageUtil("/pages/back/admin/storage/storage_list.action",null) ;
        mav.add(this.storageApplyService.list(said,pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
        return mav ;
    }
    @Override
    public String getUploadDir() {
        return "/upload/storage";
    }
}
