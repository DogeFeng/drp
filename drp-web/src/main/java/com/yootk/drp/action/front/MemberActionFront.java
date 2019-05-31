package com.yootk.drp.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.servlet.web.CookieUtil;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.drp.service.front.member_module.IMemberServiceFront;
import com.yootk.drp.vo.Member;

@Controller
public class MemberActionFront extends AbstractAction {
    @Autowired
    private IMemberServiceFront memberServiceFront;

    /**
     * 实现用户注册操作
     * @param vo 用户注册的实例对象
     * @return 注册成功返回登录页面
     * @throws Exception 执行异常
     */
    @RequestMapping("/member_add")
    public ModuleAndView add(Member vo)throws Exception{
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        if(this.memberServiceFront.add(vo)){
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "用户注册成功！");
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/member_login.action");
        }else{
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "用户注册失败！");
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/member_login.action");
        }
        return mav ;
    }
    /**
     * 登录前的页面跳转处理
     *
     * @return 返回登录页面
     */
    @RequestMapping("/member_login_pre")
    public ModuleAndView loginPre() {
        ModuleAndView mav = new ModuleAndView("/login.jsp");
        return mav;
    }

    /**
     * 用户登录注销，登录注销后所有的Cookie信息将被删除
     *
     * @return 提示页面，随后跳转回登录页
     */
    @RequestMapping("/member_logout")
    public ModuleAndView loginout() {
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp");
        CookieUtil.clean(ServletObject.getResponse(), "info");
        ServletObject.getRequest().getSession().invalidate();
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/index.jsp");
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "成功注销，下次再见！");
        return mav;
    }

    /**
     * 验证码检测，用于ajax异步验证处理
     *
     * @param code 输入验证码
     */
    @RequestMapping("/code_check")
    public void check(String code) {
        String rand = (String) ServletObject.getRequest().getSession().getAttribute("rand");
        if (rand == null || "".equals(rand)) {
            super.print(false);
        } else {
            super.print(rand.equalsIgnoreCase(code));
        }
    }

    /**
     * 用户登录处理
     *
     * @param vo         包含有用户登录信息
     * @param rememberme 是否要执行免登录
     * @return 登录成功返回信息提示页（随后跳转到商品列表页），登录失败返回登录页
     */
    @RequestMapping("/member_login")
    public ModuleAndView loginMember(Member vo, String rememberme){
        ModuleAndView mav = new ModuleAndView("/member_login_pre.action");
        vo.setPassword(EncryptUtil.encode(vo.getPassword()));
        try {
            if (memberServiceFront.login(vo)) {
                ServletObject.getRequest().getSession().setAttribute("mid", vo.getMid());
                mav.setView("/pages/plugins/forward.jsp");
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/index.jsp");
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "登录成功，欢迎您的访问！ ");
                if (rememberme != null && "true".equals(rememberme)) {
                    // 将用户信息保存在Cookie之中，方便用户下一次免登录操作
                    CookieUtil.set("info", vo.getMid() + ":" + vo.getPassword(), ServletObject.getResponse());
                }
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/login.jsp");
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, "登录失败，错误的用户名或密码！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
