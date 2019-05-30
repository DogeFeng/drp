package com.yootk.drp.service.back.distribution_module;

import com.yootk.drp.vo.Distribution_details;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDistribution_detailsService {
    public boolean add(Distribution_details vo) throws Exception;

    /**
     * 根据用户编号查询出购物车之中的所有信息
     * @param mid 用户编号
     * @return 返回如下内容
     * 1.key = allGoods，value = 商品信息List集合；
     * 2.key = details，value = 出库信息map集合；
     * @throws Exception
     */
    public Map<String,Object> listByMid(String mid)throws Exception;

    /**
     * 进行出库详情的批处理操作
     * @param details 要修改的数据信息
     * @return 成功返回true，失败返回false
     * @throws Exception
     */
    public boolean editBatch(List<Distribution_details> details) throws Exception;

    /**
     * 根据仓库管理员编号和待出库商品编号，删除带出库商品
     * @param mid 仓库管理员编号
     * @param gids 待出库商品编号
     * @return
     * @throws Exception
     */
    public boolean deleteByMidAndGid(String mid, Set<Long> gids)throws Exception;
}
