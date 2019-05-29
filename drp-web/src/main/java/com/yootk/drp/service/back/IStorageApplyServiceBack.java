package com.yootk.drp.service.back;

import com.yootk.drp.vo.StorageApply;
import com.yootk.drp.vo.Warehouse;

import java.util.Map;
import java.util.Set;

public interface IStorageApplyServiceBack {
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

    public Map<String,Object> preEdit(Long said)throws Exception ;
    public boolean edit(StorageApply apply)throws Exception ;
    public Map<String,Object> list(Long said,Long currentPage,Integer lineSize,String column,String keyWord)throws Exception ;
    /**
     * 根据入库的编号查询此入库操作的详细内容
     * @param sadid 入库编号
     * @return 入库详细显示的时候需要如下的数据内容：
     * 1、key = storageApply 、value = 入库操作的对象；
     * 2、key = detials、value = 商品信息，包含了（said=num）的Map集合
     * @throws Exception
     */
    public Map<String,Object> getDetails(Long sadid)throws Exception ;
}
