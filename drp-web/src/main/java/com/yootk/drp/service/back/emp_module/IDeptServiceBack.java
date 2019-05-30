package com.yootk.drp.service.back.emp_module;

import com.yootk.drp.vo.Dept;

import java.sql.SQLException;
import java.util.Map;

public interface IDeptServiceBack {
    /**
     * 部门列表查询
     * 包括部门名称、领导姓名
     * @return Map集合
     * key = allDepts,value = Dept 的 List 集合,使用 findAll() 方法
     * key = allManagers，value = Member 的 Map 集合,key = mid,value = name
     */
    public Map<String,Object> list() throws SQLException;

    /**
     * 部门编辑
     * 查询修改后的部门名称是否已存在，如果不存在则调用 doEdit() 方法进行修改操作
     * @param dept 修改后的部门信息
     * @return 修改成功返回true，否则返回false
     */
    public boolean edit(Dept dept) throws SQLException;
}
