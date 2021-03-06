package com.yootk.drp.dao.emp_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmpDAO extends IBaseDAO<String, Member> {
    /**
     * 查询所有雇员信息
     * 查询 type = 1 的人员
     * @param currentPage 当前所在页
     * @param lineSize 每页显示数据行数
     * @return 雇员的 List 集合
     * @throws SQLException
     */
    public List<Member> findEmpSplit(Long currentPage, Integer lineSize) throws SQLException;

    /**
     * 查询所有雇员信息
     * 查询 type = 1 的人员
     * @param currentPage 当前所在页
     * @param lineSize 每页显示数据行数
     * @param column 要进行模糊查询的列
     * @param keyWord 模糊查询关键字
     * @return 雇员的 List 集合
     * @throws SQLException
     */
    public List<Member> findEmpSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;

    /**
     * 查询雇员信息
     * @param ids
     * @return Map 集合
     * key = mid，value = name
     */
    public Map<String, String> findMembersMapById(List<String> ids) throws SQLException;

    public Member findByEmail(String email) throws SQLException ;
    public Member findByphone(String phone) throws SQLException ;

}
