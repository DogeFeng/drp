package com.yootk.drp.service.front.member_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.member_module.IMemberDAO;
import com.yootk.drp.service.front.member_module.IMemberServiceFront;
import com.yootk.drp.vo.Member;


@Service
public class MemberServiceForntImpl extends AbstractService implements IMemberServiceFront {
    @Autowired
    private IMemberDAO memberDAO ;



    @Override
    public boolean add(Member vo) throws Exception {
        return this.memberDAO.doCreate(vo) ;
    }

    @Override
    public boolean login(Member vo) throws Exception {
        Member member = this.memberDAO.findById(vo.getMid()) ;//根据mid获取Member的信息
        if(member != null){
            return member.getPassword().equals(vo.getPassword()) ;
        }
        return false;
    }
}
