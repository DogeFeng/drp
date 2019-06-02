package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.drp.dao.customer_manage_module.ICRItemDAO;
import com.yootk.drp.dao.customer_manage_module.ICustomerDAO;
import com.yootk.drp.dao.customer_manage_module.ICustomerRecordDAO;
import com.yootk.drp.service.back.customer_manage_module.ICustomerRecordServiceBack;
import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;
import com.yootk.drp.vo.CRItem;
import com.yootk.drp.vo.Customer;
import com.yootk.drp.vo.CustomerRecord;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerRecordServiceBackImpl extends AbstractService implements ICustomerRecordServiceBack {
    @Autowired
    private ICRItemDAO crItemDAO ;
    @Autowired
    private ICustomerRecordDAO customerRecordDAO ;
    @Autowired
    private ICustomerDAO customerDAO ;

    @Override
    public List<CRItem> preInput() throws SQLException {
        return crItemDAO.findAll() ;
    }

    @Override
    public boolean add(CustomerRecord customerRecord) throws SQLException {
       if (customerRecordDAO.doCreate(customerRecord)){
           Customer customer = customerDAO.findById(customerRecord.getCuid()) ;
           customer.setConnum(customer.getConnum() + 1);
           return true ;
       }else{
           return false ;
       }
    }

    @Override
    public List<CustomerRecord> list(Long cuid,Long currentPage,Integer lineSize) throws SQLException {
        return customerRecordDAO.findAllById(cuid,currentPage,lineSize) ;
    }

    @Override
    public Long allCount(Long cuid) throws SQLException {
        return customerRecordDAO.getAllCount("cuid",cuid);
    }

}
