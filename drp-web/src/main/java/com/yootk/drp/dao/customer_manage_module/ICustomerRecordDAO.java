package com.yootk.drp.dao.customer_manage_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.CustomerRecord;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRecordDAO extends IBaseDAO<Long, CustomerRecord> {
    /**
     * 根据顾客 id 查询全部沟通记录
     * @param cuid 要查询的客户id
     * @return 该客户回访记录的 List<CustomerRecord> 集合
     */
    public List<CustomerRecord> findAllById(Long cuid,Long currentPage,Integer lineSize) throws SQLException;

    public Long getAllCount(String column,Long aLong) throws SQLException;
}
