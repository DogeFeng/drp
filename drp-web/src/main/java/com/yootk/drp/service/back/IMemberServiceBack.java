package com.yootk.drp.service.back;

import com.yootk.common.annotation.Autowired;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.Map;

public interface IMemberServiceBack {
    /**
     * 雇员信息的查询操作
     * 查询雇员的照片、姓名、级别、部门、如用日期、工资、联系电话
     * @param currentPage 当前所在页
     * @param lineSize 每页显示数据行数
     * @param column 要进行模糊查询的列
     * @param keyWord 模糊查询关键字
     * @return Map集合
     * key = allMembers，value = 所有雇员的 List<Member> 集合，使用 findEmpSplit() 方法
     * key = allRecorders，value = 查询的数据统计 Long ，使用 getAllCount() 方法
     * key = allDepts，value = 所有 Dept 的 Map<Long,String> 集合 ，使用 findAllMap() 方法
     * key = allLevels,value = 所有 Level 的 Map<Long ,String> 集合 ，使用 findAllMap() 方法
     */
    public Map<String ,Object> list(Long currentPage,Integer lineSize, String column, String keyWord) throws SQLException;

    /**
     * 雇员信息修改前数据回填
     * @param mid 要修改的雇员id
     * @return Map集合
     * key = member，value = 要修改的雇员的 VO 对象，使用 findById() 方法
     * key = allDepts，value = 所有 Dept 的 Map<Long,String> 集合 ，使用 findAllMap() 方法
     * key = allLevels,value = 所有 Level 的 Map<Long ,String> 集合 ，使用 findAllMap() 方法
     */
    public Map<String,Object> preEdit(String mid) throws SQLException;

    public boolean edit(Member member) throws SQLException;

    /**
     * 雇员增加前的查询操作
     * @return 返回 Map 集合
     * key = allDepts,value = 所有 Dept 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * key = allLevels,value = 所有 Level 的 Map<Long,String> 集合,使用 findAllMap() 方法
     * @throws SQLException
     */
    public Map<String,Object> preAdd() throws SQLException ;

    /**
     * 雇员增加操作
     * 查询雇员 id、phone、email是否已存在，如果不存在则进行增加操作
     * @param member 要增加的雇员的全部信息
     * @return 增加成功返回 true，否则返回 false
     * @throws SQLException
     */
    public boolean add(Member member) throws SQLException ;
}
