package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.dao.IEmpDAO;
import com.yootk.drp.dao.ILevelDAO;
import com.yootk.drp.service.back.IMemberServiceBack;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceBackImpl extends AbstractService implements IMemberServiceBack {
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
        return empDAO.doEdit(member) ;
    }

    @Override
    public Map<String, Object> preAdd() throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allDepts",deptDAO.findAllMap()) ;
        map.put("allLevels",levelDAO.findAllMap()) ;
        return null;
    }

    @Override
    public boolean add(Member member) throws SQLException {
        if (empDAO.findById(member.getMid()) != null){
            return false ;
        }
        if (empDAO.findByEmail(member.getEmail()) != null){
            return false ;
        }
        if (empDAO.findByphone(member.getPhone()) != null){
            return false ;
        }
        return empDAO.doCreate(member);
    }
}
