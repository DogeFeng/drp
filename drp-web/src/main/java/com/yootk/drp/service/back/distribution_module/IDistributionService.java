package com.yootk.drp.service.back.distribution_module;

import com.yootk.drp.vo.Distribution;

import java.util.Map;
import java.util.Set;

public interface IDistributionService {
    /**
     * 根据仓库管理员编号和商品编号的集合查询出所有的商品内容
     * @param mid 当前仓库管理员编号
     * @param gids 要显示的商品编号
     * @return 返回如下的信息内容
     * 1.key = details,value = (Map)保存商品编号和购买数量的对应关系
     * 2.key = allGoods，value = （List）保存所有的要购买的商品信息
     * 3.key = allProvinces,value = (List)保存所有的省份数据
     * @throws Exception
     */
    public Map<String,Object> preAdd(String mid) throws Exception;

    /**
     * 实现出库单的创建
     * @param mid
     * @return
     * @throws Exception
     */
    public boolean add(String mid, Distribution vo) throws Exception;
}
