package com.yootk.drp.service.back.distribution_module;

import com.yootk.drp.vo.Distribution;
import com.yootk.drp.vo.Warehouse;

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

    /**
     * 实现根据出库单状态进行分页的处理操作
     * @param status 出库单状态
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return 返回如下内容：
     * 1.key = allDistributions ,value = (List集合)本状态所有的出库单；
     * 2.key = allRecorders，value = （Long）本状态出库单总数量
     * @throws Exception
     */
    public Map<String,Object>  list(Integer status,String column,String keyWord,Long currentPage,Integer lineSize) throws Exception;

    /**
     * 实现根据出库单号，查询出所有的出库详情单
     * @param dsid 出库单号
     * @return
     * 1.key = distribution ,value = 出库单vo对象；
     * 2.key = allDists，value = 出库详情单List集合；
     * 3.key = allProvinces，value = 所有省份Map集合，用于回显；
     * 4.key = allCitys，value = 所有城市Map集合，用于回显；
     * @throws Exception
     */
    public Map<String,Object> listDetails(Long dsid) throws Exception;

    /**
     * 实现出库单申请状态的修改
     * @param vo 要修改的出库单
     * @return
     * @throws Exception
     */
    public boolean editStatus(Distribution vo) throws Exception;

    /**
     * 编辑信息前的数据回显
     * @param dsid 出库单编号
     * @return
     * 1.key = dist，value = 出库单详情数据vo
     * 2.key = allCitys，value = 根据出库单的pid，查找到的所有城市信息
     * 3.key = allProvinces,value = 所有的省份信息；
     * @throws Exception
     */
    public Map<String,Object> preEdit(Long dsid) throws Exception;

    /**
     * 修改出库单
     * @param vo 要修改的数据
     * @return
     * @throws Exception
     */
    public boolean edit(Distribution vo) throws Exception;
}
