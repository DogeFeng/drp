package com.yootk.drp.dao.emp_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.vo.Dept;

import java.sql.SQLException;
import java.util.Map;

public interface IDeptDAO extends IBaseDAO<Integer, Dept> {
    /**
     * 查询所有 Level
     * @return  Map 集合
     * key = did，value = dname
     */
    public Map<Long,String> findAllMap() throws SQLException;

    /**
     * 根据部门名称查询部门信息
     * @param dname 要查询的部门的名称
     * @return 返回包含部门信息的 VO 类对象
     */
    public Dept findByDname(String dname) throws SQLException;
}
