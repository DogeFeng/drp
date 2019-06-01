package com.yootk.drp.dao.goods_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {
    /**
     * 根据已有的商品编号查询对应的商品的数据信息
     * @param gids 要查询的商品编号集合
     * @return 返回所有的商品信息列表
     * @throws SQLException 数据层异常
     */
    public List<Goods> findAllByGids(Set<Long> gids)throws SQLException ;
}
