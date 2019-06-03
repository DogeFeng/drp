package com.yootk.drp.dao.goods_module;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:49
 * @Description:
 */
public interface IGoodsDAO extends IBaseDAO<Long , Goods> {
    /**
     * 通过name，模糊查询
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Goods> findLinkName(String name) throws SQLException ;

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

    public Long getAllCountFlagAndStid(Long stid ,String column, String keyWord , int delflag) throws SQLException ;
    public Long getAllCountFlagAndStid(Long stid ,int delflag) throws SQLException ;
    public List<Goods> findSplitFlagAndStid(Long stid ,Long currentPage, Integer lineSize, String column, String keyWord , int delflag) throws SQLException ;
    public List<Goods> findSplitFlagAndStid(Long stid ,Long currentPage, Integer lineSize , int delflag) throws SQLException ;
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException;

    /**
     * 创建出库单成功，修改对应商品库存数量
     * @param
     * @return
     * @throws SQLException
     */
    public boolean doUpdateBatch(List<Goods> updateGoods) throws SQLException;
}