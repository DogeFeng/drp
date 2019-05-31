package com.yootk.drp.dao.goods_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:49
 * @Description:
 */
public interface IGoodsDAO extends IBaseDAO<Long , Goods> {
    /**
     * 查询所有商品信息
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return List<Goods>
     * @throws SQLException
     */
    public List<Goods> findAllFlag(int delflag) throws SQLException;

    /**
     * 分页查询所有商品
     * @param currentPage 当前页数
     * @param lineSize 每页显示行数
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return List<Goods>
     * @throws SQLException
     */
    public List<Goods> findSplitFlag(Long currentPage, Integer lineSize , int delflag) throws SQLException ;

    /**
     * 根据已有商品编号查询出所有的商品信息
     * @param gids 所有商品编号
     * @return 所有对应的商品信息
     * @throws SQLException
     */
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException;
    /**
     * 分页模糊查询所有商品
     * @param currentPage 当前页数
     * @param lineSize  每页显示行数
     * @param column 要执行模糊查询的数据列
     * @param keyWord 要执行模糊查询的关键字
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return List<Goods>
     * @throws SQLException
     */
    public List<Goods> findSplitFlag(Long currentPage, Integer lineSize, String column, String keyWord , int delflag) throws SQLException ;

    /**
     * 进行数据表的数据量统计
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return List<Goods>
     * @throws SQLException
     */
    public Long getAllCountFlag(int delflag) throws SQLException ;

    /**
     * 进行数据表的数据量的模糊统计
     * @param column 要执行模糊查询的数据列
     * @param keyWord 要执行模糊查询的关键字
     * @param delflag 删除标记。0：未删除、1：已删除
     * @return List<Goods>
     * @throws SQLException
     */
    public Long getAllCountFlag(String column, String keyWord , int delflag) throws SQLException ;
}
