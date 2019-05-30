package com.yootk.drp.dao.emp_module.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.emp_module.ILevelDAO;
import com.yootk.drp.vo.Level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {
    @Override
    public boolean doCreate(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Integer> integers) throws SQLException {
        return false;
    }

    @Override
    public Level findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public List<Level> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Map<Long, String> findAllMap() throws SQLException {
        super.conn = DatabaseConnection.getConnection() ;
        Map<Long,String> map = new HashMap<>() ;
        String sql = "SELECT lid,title FROM level" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        while(rs.next()){
            map.put(rs.getLong(1),rs.getString(2)) ;
        }
        return map ;
    }
}
