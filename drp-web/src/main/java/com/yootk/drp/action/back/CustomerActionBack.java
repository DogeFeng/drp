package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.customer_manage_module.ICityServiceBack;
import com.yootk.drp.service.back.customer_manage_module.ICustomerRecordServiceBack;
import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;
import com.yootk.drp.service.back.emp_module.IEmpServiceBack;
import com.yootk.drp.vo.CRItem;
import com.yootk.drp.vo.Customer;
import com.yootk.drp.vo.CustomerRecord;

import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping("/pages/back/admin/customer/")
public class CustomerActionBack extends AbstractAction {
    @Autowired
    private ICustomerServiceBack customerServiceBack ;
    @Autowired
    private ICityServiceBack cityService ;
    @Autowired
    private IEmpServiceBack empServiceBack ;
    @Autowired
    private ICustomerRecordServiceBack customerRecordServiceBack;

    @RequestMapping("customer_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/customer/customer_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/customer/customer_list.action","客户姓名:name");
        Set<Integer> status = new HashSet<>() ;
        status.add(1) ;
        status.add(2) ;
        try {
            mav.add(this.customerServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword(),status));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("customer_add_pre")
    public ModuleAndView addPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/customer/customer_add.jsp") ;
        try {
            mav.add(this.customerServiceBack.preAdd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("customer_add_preCity")
    public void addPre(Long pid){
        try {
            super.print(JSONObject.toJSONString(this.cityService.preAddCity(pid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("customer_add")
    public ModuleAndView add(Customer customer){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        customer.setStatus(1);
        customer.setType(1);
        try {
            if(this.customerServiceBack.add(customer)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"客户增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_list.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"客户增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_add_pre.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_add_pre.action");
        }
        return mav;
    }

    @RequestMapping("customer_audit_list")
    public ModuleAndView listAudit(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/customer/customer_audit_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/customer/customer_audit_list.action","客户姓名:name");
        Set<Integer> status = new HashSet<>() ;
        status.add(0) ;
        try {
            mav.add(this.customerServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword(),status));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("customer_list_member_modal")
    public void listModal (String mid){
        try {
            super.print(JSONObject.toJSONString(this.empServiceBack.modal(mid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("customer_record_list")
    public void listModal(Long cuid){
        try {
            super.print(JSONObject.toJSONString(this.customerRecordServiceBack.list(cuid,1L,1)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("customer_record_input_cuid")
    public void preInput(Long cuid){
        super.print(JSONObject.toJSONString(cuid));
    }

    @RequestMapping("customer_record_input_pre")
    public void preInput(){
        try{
            super.print(JSONObject.toJSONString(this.customerRecordServiceBack.preInput()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("customer_record_input")
    public ModuleAndView addRecord(String title,CustomerRecord customerRecord){
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        String note = customerRecord.getNote() ;
        customerRecord.setNote(title + "\n" + note);
        try {
            if(this.customerRecordServiceBack.add(customerRecord)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"客户联系记录增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_list.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"客户联系记录增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_list.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/customer/customer_list.action");
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/customer/";
    }
}
