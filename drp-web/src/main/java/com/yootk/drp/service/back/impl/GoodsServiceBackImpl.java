package com.yootk.drp.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.dbc.DatabaseConnection;
import com.yootk.drp.dao.IGoodsDAO;
import com.yootk.drp.dao.IMemberDAO;
import com.yootk.drp.dao.ISubtypeDAO;
import com.yootk.drp.dao.IWitemDAO;
import com.yootk.drp.service.back.IGoodsServiceBack;
import com.yootk.drp.vo.Goods;
import com.yootk.drp.vo.Subtype;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/28 15:03
 * @Description:
 */
@Service
public class GoodsServiceBackImpl implements IGoodsServiceBack {
    @Autowired
    private ISubtypeDAO subtypeDao ;
    @Autowired
    private IWitemDAO witemDao ;
    @Autowired
    private IGoodsDAO goodsDao ;
    @Autowired
    private IMemberDAO memberDao ;

    @Override
    public Map<String,Object> findById(Long gid) throws Exception {
        Map<String, Object> map = new HashMap<>() ;
        map.put("allWitem",witemDao.findAll()) ;
        map.put("goods",goodsDao.findById(gid)) ;
        return map;
    }

    @Override
    public List<Subtype> findByWitemId(Long wiid) throws Exception {
        return subtypeDao.findByWiid(wiid) ;
    }

    @Override
    public Map<String, Object> addPre() throws Exception {
        Map<String, Object> map = new HashMap<>() ;
        map.put("allWitem",witemDao.findAll()) ;
        return map;
    }

    @Override
    public boolean add(Goods goods) throws Exception {
        return goodsDao.doCreate(goods);
    }

    @Override
    public boolean edit(Goods goods) throws Exception {
        return goodsDao.doEdit(goods);
    }

    @Override
    public Map<String, Object> listGoods(Long currentPage, Integer lineSize, String column, String keyWord, int delflag) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        if(column == null || keyWord == null || "".equals(column) || "".equals(keyWord)) {
            map.put("allGoods",goodsDao.findSplitFlag(currentPage,lineSize,delflag)) ;
            map.put("allRecorders",goodsDao.getAllCountFlag(delflag)) ;
        }else {
            map.put("allGoods",goodsDao.findSplitFlag(currentPage,lineSize,column,keyWord,delflag)) ;
            map.put("allRecorders",goodsDao.getAllCountFlag(column,keyWord,delflag)) ;

        }
        map.put("allMember",memberDao.findMap()) ;
        return map;
    }

}
