package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.customer_manage_module.*;
import com.yootk.drp.dao.emp_module.IEmpDAO;
import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;
import com.yootk.drp.vo.Customer;

import java.sql.SQLException;
import java.util.*;

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
    @Autowired
    private IEmpDAO empDAO ;

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord ,Set<Integer> status) throws SQLException {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allCItems",citemDAO.findAllMap()) ;
        List<Customer> customers = new ArrayList<>() ;
        if (isEmpty(column,keyWord)){
            customers = customerDAO.findSplit(currentPage,lineSize,status) ;
            map.put("allRecorders",customerDAO.getAllCount()) ;
        }else{
            map.put("allRecorders",customerDAO.getAllCount(column,keyWord)) ;
            customers = customerDAO.findSplit(currentPage,lineSize,column,keyWord,status) ;
        }
        map.put("allCustomers",customers) ;
        List<String> mids = new ArrayList<>() ;
        for(Customer customer : customers){
            mids.add(customer.getRecorder()) ;
        }
        map.put("allEmps",empDAO.findMembersMapById(mids)) ;
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

    @Override
    public Customer getCustomer(Long cuid) throws SQLException {
        return customerDAO.findById(cuid);
    }
}
