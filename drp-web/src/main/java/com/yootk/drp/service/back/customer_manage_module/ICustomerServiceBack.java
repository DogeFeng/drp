package com.yootk.drp.service.back.customer_manage_module;

import com.yootk.drp.vo.Customer;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public interface ICustomerServiceBack {
    /**
     * 客户信息的查询操作
     * 查询雇员的照片、姓名、级别、部门、如用日期、工资、联系电话
     * @param currentPage 当前所在页
     * @param lineSize 每页显示数据行数
     * @param column 要进行模糊查询的列
     * @param keyWord 模糊查询关键字
     * @param status 要查询用户的认证状态
     * @return Map集合
     * key = allCustomers，value = 所有雇员的 List<Customer> 集合，使用 findSplit() 方法
     * key = allRecorders，value = 查询的数据统计 Long ，使用 getAllCount() 方法
     * key = allCItems，value = 所有 CItem 的 Map<Long,String> 集合 ，使用 findAllMap() 方法
     * key = allEmps,value = 所有雇员的 Map<String,String> 集合
     */
    public Map<String ,Object> list(Long currentPage, Integer lineSize, String column, String keyWord,Set<Integer> status) throws SQLException;

    /**
     * 雇员增加前的查询操作
     * @return 返回 Map 集合
     * key = allProvinces,value = 所有 Province 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allCSources,value = 所有 CSource 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allCItems,value = 所有 CItem 的 Map<Long,String> 集合,使用 findByProvince() 方法
     * @throws SQLException
     */
    public Map<String,Object> preAdd() throws SQLException ;

    /**
     * 客户信息增加操作
     * @param customer 要增加的客户的信息
     * @return 增加成功返回 true，否则返回 false
     */
    public boolean add(Customer customer) throws SQLException;

    /**
     * 根据 id 获取客户信息
     * @param cuid
     * @return
     */
    public Customer getCustomer(Long cuid) throws SQLException;

    /**
     * 客户认证操作
     * @param cuid 认证的客户 id
     * @param status 认证状态
     * @param note
     * @param recorder 审核者/记录者
     * @return
     */
    public boolean editAudit(Long cuid,Integer status,String note,String recorder) throws SQLException;
}
