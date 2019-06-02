package com.yootk.drp.service.back.customer_manage_module;

import com.yootk.drp.vo.CRItem;
import com.yootk.drp.vo.CustomerRecord;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRecordServiceBack {
    /**
     * 客户沟通增加前的查询操作，查询客户联系类型
     * @return 返回所有客户联系类型的 List<CRItem> 集合
     */
    public List<CRItem> preInput() throws SQLException;

    /**
     * 客户联系记录的增加操作
     * @param customerRecord
     * @return
     */
    public boolean add(CustomerRecord customerRecord) throws SQLException;

    /**
     * 根据客户 id 查询所有沟通记录
     * @param cuid
     * @return 客户沟通记录的 List 集合
     */
    public List<CustomerRecord> list(Long cuid,Long currentPage,Integer lineSize) throws SQLException;

    /**
     * 查询某客户联系记录数量
     * @param cuid
     * @return
     */
    public Long allCount(Long cuid) throws SQLException;
}
