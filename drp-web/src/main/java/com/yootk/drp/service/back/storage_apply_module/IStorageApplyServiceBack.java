package com.yootk.drp.service.back.storage_apply_module;

import com.yootk.drp.vo.StorageApply;
import com.yootk.drp.vo.Warehouse;

import java.util.Map;
import java.util.Set;

public interface IStorageApplyServiceBack {
    public Map<String,Object> detailsPreAdd(Set<Long> gids)throws Exception ;
    public boolean detailsAdd(StorageApply apply,Set<Long> gids)throws Exception ;
    /**
     * 列出所有省份和商品以及仓库的信息
     * @return 返回以下的信息内容：
     * 1、key = allProvinces、value = 省份信息；
     * 2、key = allWitems、value = 商品信息；
     * 3、key = allWarehouses、value =  仓库信息。
     * @throws Exception SQL异常
     */
    public Map<String,Object> preAdd()throws Exception ;
    public boolean add(StorageApply apply)throws Exception ;

    /**
     * 列出所有的入库清单的详细内容
     * @param said 入库清单编号
     * @return 返回以下详细内容（Map集合）；
     * 1、key = allStorageApply、value = 入库申请表的对象；
     * 2、key = allCitys、value = 查询出省份对应的城市内容（根据StorageApply对象进行查找）
     * @throws Exception 数据层异常
     */
    public Map<String,Object> preEdit(Long said)throws Exception ;
    public boolean edit(StorageApply apply)throws Exception ;
    public Map<String,Object> list(Long currentPage,Integer lineSize,String column,String keyWord)throws Exception ;

    /**
     * 根据入库清单编号查询此清单的详细内容
     * @param said 要查询的清单编号
     * @return 清单详情显示的时候需要如下的数据内容：
     * 1、key = allStorageApplies、value = 清单对象；
     * 2、key = details、value  = 清单详情内容，包含了（gid=num）的Map集合；
     * @throws Exception 数据层异常
     */
    public Map<String,Object> getDetails(Long said)throws Exception ;

}
