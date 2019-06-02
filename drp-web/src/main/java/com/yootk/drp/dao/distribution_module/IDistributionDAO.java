package com.yootk.drp.dao.distribution_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Distribution;

import java.sql.SQLException;
import java.util.List;

public interface IDistributionDAO extends IBaseDAO<Long,Distribution> {
    /**
     * 取得最后一次增长后的出库表id；
     * @return
     * @throws SQLException
     */
    public Long findLastId() throws SQLException;

    /**
     * 下面四个方法均为根据出库单状态的分页查询
     * @param status
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Distribution> findSplit(Integer status,String column,String keyWord,Long currentPage,Integer lineSize) throws SQLException;

    public List<Distribution> findSplit(Integer status,Long currentPage,Integer lineSize) throws SQLException;

    public Long getAllCount(Integer status,String column,String keyWord) throws SQLException;

    public Long getAllCount(Integer status) throws SQLException;

    /**
     * 修改出库单申请状态
     * @param vo 要修改的出库单
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(Distribution vo) throws SQLException;
}
