package com.yootk.drp.service.back.emp_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.emp_module.IDeptDAO;
import com.yootk.drp.dao.emp_module.IEmpDAO;
import com.yootk.drp.dao.emp_module.ILevelDAO;
import com.yootk.drp.service.back.emp_module.IEmpServiceBack;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmpServiceBackImpl extends AbstractService implements IEmpServiceBack {
    @Autowired
    private IEmpDAO empDAO ;
    @Autowired
    private IDeptDAO deptDAO ;
    @Autowired
    private ILevelDAO levelDAO ;

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allDepts",deptDAO.findAllMap()) ;
        map.put("allLevels",levelDAO.findAllMap()) ;
        if (isEmpty(column,keyWord)){
            map.put("allRecorders",empDAO.getAllCount()) ;
            map.put("allMembers",empDAO.findEmpSplit(currentPage, lineSize)) ;
        }else{
            map.put("allRecorders",empDAO.getAllCount(column,keyWord)) ;
            map.put("allMembers",empDAO.findEmpSplit(currentPage, lineSize, column, keyWord)) ;
        }
        return map;
    }

    @Override
    public Map<String, Object> preEdit(String mid) throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("member",empDAO.findById(mid)) ;
        map.put("allDepts",deptDAO.findAllMap()) ;
        map.put("allLevels",levelDAO.findAllMap()) ;
        return map ;
    }

    @Override
    public boolean edit(Member member) throws SQLException {
        Member oldMember = empDAO.findById(member.getMid()) ;
        if (! member.getPhone().equals(oldMember.getPhone())){
            if (empDAO.findByphone(member.getPhone()) != null) {
                return false;
            }
        }
        if (member.getPassword().equals("**********")){
            member.setPassword(oldMember.getPassword());
        }else{
            member.setPassword(EncryptUtil.encode(member.getPassword())) ;
        }
        System.out.println("[service_member_back_edit member]" + member);
        return empDAO.doEdit(member) ;
    }

    @Override
    public Map<String, Object> preAdd() throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allDepts",deptDAO.findAllMap()) ;
        map.put("allLevels",levelDAO.findAllMap()) ;
        return map;
    }

    @Override
    public boolean add(Member member) throws SQLException {
        if (empDAO.findById(member.getMid()) != null){
            return false ;
        }
//        这里有个神奇的邮箱，按理说他不能重复
//        if (empDAO.findByEmail(member.getEmail()) != null){
//            return false ;
//        }
        if (empDAO.findByphone(member.getPhone()) != null){ //数据库全是重复手机号，我也很绝望
            return false ;
        }
        member.setPassword(EncryptUtil.encode(member.getPassword())) ;
        return empDAO.doCreate(member);
    }
}
