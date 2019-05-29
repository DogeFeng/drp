package com.yootk.drp.service.back;

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
     * 1.delflag=1,未删除
     * 2.lastin=当前时间，最后进货时间
     * @param goods 商品信息
     * @return boolean
     *  添加成功返回true，失败false
     * @throws Exception
     */
    public boolean add(Goods goods) throws Exception ;

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
