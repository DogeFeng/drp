package com.yootk.drp.service.back;

import com.yootk.drp.vo.City;
import com.yootk.drp.vo.Warehouse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IWarehouseServiceBack  {
    /**
     * 在创建仓库之前查询出省份，及对应的城市，和仓库类型的下拉列表框选项
     * @return 返回内容如下：
     * 1.key = allProvinces ,value = 所有省份分类List集合
     * 2.key = allWitems,value = 所有仓库分类List集合
     * @throws Exception
     */
    public Map<String,Object> preAdd()throws Exception;

    /**
     * 实现仓库的创建
     * @param warehouse 仓库创建信息
     * @return 成功返回true
     * @throws Exception
     */
    public boolean add(Warehouse warehouse) throws Exception;

    /**
     * 实现仓库的列表显示
     * @param column 查询的列
     * @param keyWord 查询关键字
     * @param currentPage 当前页数
     * @param linesize 每行显示个数
     * @return
     * @throws Exception
     */
    public Map<String,Object> list(String column,String keyWord,Long currentPage,Integer linesize) throws Exception;
}
