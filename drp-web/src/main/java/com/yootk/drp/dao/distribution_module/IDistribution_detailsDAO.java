package com.yootk.drp.dao.distribution_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Distribution_details;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDistribution_detailsDAO extends IBaseDAO<Long, Distribution_details> {
    public boolean doCreateByGid(Distribution_details vo) throws SQLException;
    public boolean doEditByGid(Distribution_details vo) throws SQLException;
    public Integer findByGid(Long gid) throws SQLException;

    /**
     * 根据仓库管理员查找出库信息
     * @param mid 管理员ID
     * @return
     * @throws SQLException
     */
    public Map<Long,Integer> findAllByMid(String mid) throws SQLException;

    /**
     *进行出库详情的批量修改
     * @param details 要修改的购物车内容
     * @return  修改成功返回true
     * @throws SQLException
     */
    public boolean doEditBatch(List<Distribution_details> details) throws SQLException;

    /**
     * 根据仓库管理员编号和待出库商品编号删除待出库商品
     * @param mid 仓库管理员编号
     * @param gids 要清除的所有商品编号
     * @return 删除成功返回true，否则返回false
     * @throws SQLException
     */
    public boolean doRemoveByMidAndGid(String mid, Set<Long> gids) throws SQLException;
}
