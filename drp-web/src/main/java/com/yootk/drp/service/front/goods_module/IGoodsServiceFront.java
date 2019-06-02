package com.yootk.drp.service.front.goods_module;

import com.yootk.drp.vo.Goods;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/30 10:12
 * @Description:
 */
public interface IGoodsServiceFront {
    /**
     * 查询所有的一级分类和二级分类
     * @return 返回Map集合
     *  1.key=allSubtype、value=List<Subtype></>
     *  2.key=allWitem、value=List<Witem></>
     * @throws Exception
     */
    public Map<String,Object> findSubtypeAndWitem(String name) throws Exception ;

    /**
     * 通过二级分类查询商品信息
     * @param stid
     * @param delflag
     * @return
     * @throws Exception
     */
    public Map<String, Object> findSubtypeIdGoods(Long stid , Long currentPage, Integer lineSize, String column, String keyWord , int delflag) throws Exception ;

    /**
     * 根据id进行查询
     * @param gid
     * @return
     * @throws Exception
     */
    public Goods get(Long gid) throws Exception ;
}
