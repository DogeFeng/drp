package com.yootk.drp.service.back.customer_manage_module.impl;

import com.yootk.drp.service.back.customer_manage_module.ICustomerServiceBack;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerServiceBackImplTest {

    @Test
    public void preAdd() {
        ICustomerServiceBack customerServiceBack = new CustomerServiceBackImpl() ;
        try {
            Map<String,Object> map = customerServiceBack.preAdd() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}