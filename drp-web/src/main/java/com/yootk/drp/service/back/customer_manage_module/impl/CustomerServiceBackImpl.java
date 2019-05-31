package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.customer_manage_module.*;
import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;
import com.yootk.drp.vo.Customer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord ,Set<Integer> status) throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allCItems",citemDAO.findAllMap()) ;
        if (isEmpty(column,keyWord)){
            map.put("allRecorders",customerDAO.getAllCount()) ;
            map.put("allCustomers",customerDAO.findSplit(currentPage, lineSize,status)) ;
        }else{
            map.put("allRecorders",customerDAO.getAllCount(column,keyWord)) ;
            map.put("allCustomers",customerDAO.findSplit(currentPage, lineSize, column, keyWord,status)) ;
        }
        return map ;
    }

    @Override
    public Map<String, Object> preAdd() throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allCItems",citemDAO.findAllMap()) ;
        map.put("allCSources",csourceDAO.findAllMap()) ;
        map.put("allProvinces",provinceDAO.findAllMap()) ;
        return map ;
    }

    @Override
    public boolean add(Customer customer) throws SQLException {
        return customerDAO.doCreate(customer) ;
    }
}
