package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.storage_apply_module.IStorageApplyServiceBack;
import com.yootk.drp.vo.StorageApply;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        apply.setAppmid("allen");
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
    @RequestMapping("storage_edit_show")
    public ModuleAndView show(Long said) throws Exception {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_edit.jsp") ;
        mav.add(this.storageApplyService.preEdit(said));
        return mav ;
    }
    @RequestMapping("storage_edit_pre")
    public ModuleAndView editPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_edit_show.action") ;
        try {
            mav.add(this.storageApplyService.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_edit")
    public ModuleAndView edit(StorageApply apply){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        apply.setAppmid("allen");
        try {
            if (this.storageApplyService.edit(apply)) {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库修改成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_list.action");
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "仓库修改失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_edit_pre.action?said=" + apply.getSaid());
            }
        }catch (Exception e){
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_edit_pre.action?said=" + apply.getSaid());
        }
        return mav ;
    }

    @RequestMapping("storage_list")
    public ModuleAndView list(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_myself.jsp") ;
        PageUtil pu = new PageUtil("/pages/back/admin/storage/storage_list.action","选项: |申请标题:title") ;
        try {
            mav.add(this.storageApplyService.list(pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

//    /**
//     * 查询入库清单的详细信息，并根据商品编号查询商品信息
//     * @return 清单详情显示
//     */
//    @RequestMapping("storage_list_details")
//    public ModuleAndView listDetails(Long said){
//        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_details.jsp");
//        try {
//            mav.add(this.storageApplyService.getDetails(said));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mav ;
//    }
    @RequestMapping("storage_list_show")
    public ModuleAndView listShow(Long said){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_details.jsp") ;
        try {
            mav.add(this.storageApplyService.preEdit(said));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
//    @RequestMapping("storage_list_pre")
//    public ModuleAndView listPre(){
//        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage_list_show.action") ;
//        try {
//            mav.add(this.storageApplyService.preAdd());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mav ;
//    }
//
//    /**
//     * 实现入库申请单的商品创建前的处理
//     * @return入库清单的创建页面
//     */
//    @RequestMapping("storage_details_add_pre")
//    public ModuleAndView addPreDetails(Long [] gid){
//        Set<Long> gidSet = new HashSet<>() ;
//        gidSet.addAll(Arrays.asList(gid)) ;//将数组通过List添加到Set之中
//        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_pre.action") ;
//        try {
//            mav.add(this.storageApplyService.detailsPreAdd(gidSet));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mav ;
//    }
//    @RequestMapping("storage_details_add")
//    public ModuleAndView detailsAdd(StorageApply apply,Long [] gid)throws Exception{
//        Set<Long> gidSet = new HashSet<>() ;
//        gidSet.addAll(Arrays.asList(gid)) ;
//        System.out.println("apply =" + apply + ",gid=" + gidSet);
//        ModuleAndView mav = new ModuleAndView() ;
//        if(this.storageApplyService.detailsAdd(apply,gidSet)){
//            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"商品入库成功!");
//            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_details_add_pre.action");
//        }else{
//            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"商品入库失败!");
//            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/storage/storage_details_add_pre.action");
//        }
//        return mav ;
//    }
    @Override
    public String getUploadDir() {
        return "/upload/storage/";
    }
}
