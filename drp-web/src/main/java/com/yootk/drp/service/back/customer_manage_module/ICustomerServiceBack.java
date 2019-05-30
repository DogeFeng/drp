package com.yootk.drp.service.back.customer_manage_module;

import java.sql.SQLException;
import java.util.Map;

public interface ICustomerServiceBack {
    /**
     * 客户信息的查询操作
     * 查询雇员的照片、姓名、级别、部门、如用日期、工资、联系电话
     * @param currentPage 当前所在页
     * @param lineSize 每页显示数据行数
     * @param column 要进行模糊查询的列
     * @param keyWord 模糊查询关键字
     * @return Map集合
     * key = allCustomers，value = 所有雇员的 List<Customer> 集合，使用 findSplit() 方法
     * key = allRecorders，value = 查询的数据统计 Long ，使用 getAllCount() 方法
     * key = allCItems，value = 所有 CItem 的 Map<Long,String> 集合 ，使用 findAllMap() 方法
     */
    public Map<String ,Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;

    /**
     * 雇员增加前的查询操作
     * @return 返回 Map 集合
     * key = allProvinces,value = 所有 Province 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allCities,value = 所有 City 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allCSources,value = 所有 CSource 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allCItems,value = 所有 CItem 的 Map<Long(pid),MAP<Long(cid),String>> 集合,使用 findAllMap() 方法
     * @throws SQLException
     */
    public Map<String,Object> preAdd() throws SQLException ;
}
