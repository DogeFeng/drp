package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.service.front.IMemberServiceFront;
import com.yootk.drp.vo.Member;


@Service
public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
	@Autowired
	private IMemberDAO memberDAO ;
	@Override
	public boolean login(Member vo) throws Exception {
		Member member = this.memberDAO.findById(vo.getMid()) ;	// 根据mid获取Member信息
		if (member != null) {
			return member.getPassword().equals(vo.getPassword()) ;
		}
		return false;
	}

}
