package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.IDeptDAO;
import com.yootk.drp.dao.IEmpDAO;
import com.yootk.drp.dao.ILevelDAO;
import com.yootk.drp.service.back.IDeptServiceBack;
import com.yootk.drp.vo.Dept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceBackImpl extends AbstractService implements IDeptServiceBack {
    @Autowired
    private IEmpDAO empDAO ;
    @Autowired
    private IDeptDAO deptDAO ;

    @Override
    public Map<String, Object> list() throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        List<Dept> depts = deptDAO.findAll() ;
        map.put("allDepts",depts) ;
        List<String> mids = new ArrayList<>() ;
        for(Dept dept : depts){
            mids.add(dept.getMid()) ;
        }
        map.put("allManagers",empDAO.findManagersMapById(mids)) ;
        return map ;
    }

    @Override
    public boolean edit(Dept dept) throws SQLException {
        if (deptDAO.findByDname(dept.getDname()) != null){
            return false ;
        }
        return deptDAO.doEdit(dept) ;
    }
}
