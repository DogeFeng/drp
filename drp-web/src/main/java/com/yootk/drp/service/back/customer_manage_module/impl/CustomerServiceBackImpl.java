package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.customer_manage_module.*;
import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceBackImpl extends AbstractService implements ICustomerServiceBack {
    @Autowired
    private ICustomerDAO customerDAO ;
    @Autowired
    private ICItemDAO citemDAO ;
    @Autowired
    private ICSourceDAO csourceDAO ;
    @Autowired
    private IProvinceDAO provinceDAO ;
    @Autowired
    private ICityDAO cityDAO ;

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allCItems",citemDAO.findAllMap()) ;
        if (isEmpty(column,keyWord)){
            map.put("allRecorders",customerDAO.getAllCount()) ;
            map.put("allCustomers",customerDAO.findSplit(currentPage, lineSize)) ;
        }else{
            map.put("allRecorders",customerDAO.getAllCount(column,keyWord)) ;
            map.put("allCustomers",customerDAO.findSplit(currentPage, lineSize, column, keyWord)) ;
        }
        return map ;
    }

    @Override
    public Map<String, Object> preAdd() throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allCItems",citemDAO.findAllMap()) ;
        map.put("allCSources",csourceDAO.findAllMap()) ;
        map.put("allCities",cityDAO.findAllMap()) ;
        map.put("allProvinces",provinceDAO.findAllMap()) ;
        return map ;
    }
}
