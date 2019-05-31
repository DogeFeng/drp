package com.yootk.drp.service.back.storage_apply_module;

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
    public Map<String,Object> preEdit(Long wid)throws Exception ;
    public boolean edit(StorageApply apply)throws Exception ;
    public Map<String,Object> list(Long currentPage,Integer lineSize,String column,String keyWord)throws Exception ;

}
