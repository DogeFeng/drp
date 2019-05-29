package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.vo.Member;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/28 15:06
 * @Description:
 */
public interface IMemberDao extends IBaseDAO<String, Member> {
    /**
     * 查询员工id和姓名
     * @return 返回Map
     * key=ID,value=name
     * @throws SQLException
     */
    public Map<String,String> findMap() throws SQLException ;
}
