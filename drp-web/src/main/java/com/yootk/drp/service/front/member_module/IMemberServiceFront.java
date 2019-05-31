package com.yootk.drp.service.front.member_module;

import com.yootk.drp.vo.Member;

import java.util.Map;

public interface IMemberServiceFront {
    /**
     * 进行用户的增加操作
     * @param vo 用户增加的对象
     * @return 增加成功返回true，否则返回false
     * @throws Exception JDBC
     */
    public boolean add(Member vo) throws Exception ;

    /**
     * 用户登录处理，根据用户名和密码进行登录操作
     * @param vo 包含有用户名和密码（加密）
     * @return 登录成功返回true、否则返回false
     * @throws Exception SQL
     */
    public boolean login(Member vo)throws Exception ;

}
