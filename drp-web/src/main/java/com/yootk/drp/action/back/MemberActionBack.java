package com.yootk.drp.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.drp.service.back.emp_module.IMemberServiceBack;
import com.yootk.drp.util.UploadFileToServer;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;

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
    public ModuleAndView edit(Member member, MultipartFile pic) {
        System.out.println("[action_emp_edit member]" + member);
        try {
            String fileName = UploadFileToServer.upload(pic,pic.getContentType()) ;
            if(fileName != null || fileName != member.getPhoto()){
                member.setPhoto(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        try {
            if (this.memberServiceBack.edit(member)) {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"雇员修改成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/emp/emp_list.action");
            }else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "雇员修改失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/emp/emp_edit_pre.action?mid=" + member.getMid());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("emp_add_pre")
    public ModuleAndView addPre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/emp/emp_add.jsp");
        try {
            mav.add(this.memberServiceBack.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("emp_add")
    public ModuleAndView add(Member member, MultipartFile pic){
        System.out.println("[action_emp_add member]" + member);
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        try {
            String fileName = UploadFileToServer.upload(pic,pic.getContentType()) ;
            member.setPhoto(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(this.memberServiceBack.add(member)){
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"雇员增加成功！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/emp/emp_list.action");
            }else{
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME,"雇员增加失败！");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/emp/emp_add_pre.action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME,"/pages/back/admin/emp/emp_add_pre.action");
        }
        return mav ;
    }

    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
