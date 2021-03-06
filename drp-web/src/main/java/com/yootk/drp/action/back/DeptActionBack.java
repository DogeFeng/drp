package com.yootk.drp.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.drp.service.back.emp_module.IDeptServiceBack;
import com.yootk.drp.service.back.emp_module.IEmpServiceBack;
import com.yootk.drp.vo.Dept;

import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/dept/")
public class DeptActionBack extends AbstractAction{
    @Autowired
    private IDeptServiceBack deptServiceBack ;
    @Autowired
    private IEmpServiceBack empServiceBack ;

    @RequestMapping("dept_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/dept/dept_list.jsp") ;
        try {
            Map<String,Object> map = this.deptServiceBack.list() ;
            mav.add(map); // 直接将Map集合设置到request属性之中
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("dept_edit")
    public void edit(String did ,String dname) {
        Dept dept = new Dept();
        dept.setDid(Long.parseLong(did));
        dept.setDname(dname);
        try {
            super.print(this.deptServiceBack.edit(dept));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("dept_list_modal")
    public void listModal (String mid){
        try {
            super.print(JSONObject.toJSONString(this.empServiceBack.modal(mid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUploadDir() {
        return "/upload/dept";
    }
}
