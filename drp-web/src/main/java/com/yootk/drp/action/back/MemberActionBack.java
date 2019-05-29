package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.IMemberServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Dept;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/emp/")
public class MemberActionBack extends AbstractAction {

    @Autowired
    private IMemberServiceBack memberServiceBack ;

    @RequestMapping("emp_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/emp/emp_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/emp/emp_list.action","雇员姓名:name");
        try {
            mav.add(this.memberServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("emp_edit_pre")
    public ModuleAndView editPre(String mid) {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/emp/emp_edit.jsp") ;
        try {
            mav.add(this.memberServiceBack.preEdit(mid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("emp_edit")
    public ModuleAndView add(Member member, MultipartFile file) {
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        try {
            String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
            member.setPhoto(fileName);
            String msg = super.getMessge("vo.edit.failure","雇员") ;
            if (this.memberServiceBack.edit(member)) {
                msg = super.getMessge("vo.edit.success","雇员") ;
            }
            String path = "/pages/back/sdmin/emp/emp_add.action" ;
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }


    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
