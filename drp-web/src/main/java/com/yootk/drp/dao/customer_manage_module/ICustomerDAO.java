package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ICustomerDAO extends IBaseDAO<Long,Customer> {
    List<Customer> findSplit(Long currentPage, Integer lineSize, Set<Integer> status) throws SQLException;

    List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord, Set<Integer> status) throws SQLException;

    public boolean audit(Long cuid,Integer status,String note,String recorder) throws SQLException;
}
