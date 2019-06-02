package com.yootk.drp.service.back.goods_module;

import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Member;
import com.yootk.drp.vo.Subtype;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/28 11:25
 * @Description:
 */
public interface IGoodsServiceBack {

    public Map<String,Object> findgoodsShow(Long gid) throws Exception ;

    /**
     * 通过商品id，查询信息
     * @param gid
     * @return
     * @throws Exception
     */
    public Map<String,Object> findById(Long gid) throws Exception ;

    /**
     * 通过一级分类id查询二级分类id
     * @param wiid
     * @return
     * @throws Exception
     */
    public List<Subtype> findByWitemId(Long wiid) throws Exception ;

    /**
     * 商品添加前查询商品分类和子分类
     * @return Map
     *  key=allSubtype、value=List<Subtype></>
     *  key=allWitem、value=List<Witem></>
     * @throws Exception
     */
    public Map<String,Object> addPre() throws Exception ;

    /**
     * 商品添加
     * @param goods 商品信息
     * @return boolean
     *  添加成功返回true，失败false
     * @throws Exception
     */
    public boolean add(Goods goods) throws Exception ;

    /**
     * 商品修改
     * @param goods 商品信息
     * @return boolean
     *  添加成功返回true，失败false
     */
    public boolean edit(Goods goods) throws Exception ;

    /**
     * 商品查询
     * @param currentPage 当前页
     * @param lineSize 每页显示行数
     * @param column 模糊查询关键列
     * @param keyWord 模糊查询关键字
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return 返回Map集合：
     *  1.key=allGoods、value=List<Goods></>
     *  2.key=allRecorders、value=Long
     *  2.key=allMember、value=Map<String,String></>，从member表中查询mid和name，封装为map
     * @throws Exception
     */
    public Map<String,Object> listGoods(Long currentPage, Integer lineSize, String column, String keyWord , int delflag) throws Exception ;



}
