package com.yootk.drp.service.front.goods_module.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.drp.dao.goods_module.IGoodsDAO;
import com.yootk.drp.dao.goods_module.ISubtypeDAO;
import com.yootk.drp.dao.goods_module.IWitemDAO;
import com.yootk.drp.service.front.goods_module.IGoodsServiceFront;
import com.yootk.drp.vo.Goods;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: LL
 * @Date: 2019/5/30 10:15
 * @Description:
 */
@Service
public class IGoodsServiceFrontImpl implements IGoodsServiceFront {
    @Autowired
    private ISubtypeDAO subtypeDao ;
    @Autowired
    private IWitemDAO witemDao ;
    @Autowired
    private IGoodsDAO goodsDAO ;

    @Override
    public Map<String, Object> findSubtypeAndWitem(String name) throws Exception {
        Map<String, Object> map = new HashMap<>() ;
        map.put("allSubtype" ,subtypeDao.findAll()) ;
        map.put("allWitem",witemDao.findAll()) ;
        if(name == null ) {
            map.put("allGoods",null) ;
        }else {
            map.put("allGoods",goodsDAO.findLinkName(name)) ;
        }
        return map;
    }

    @Override
    public Goods get(Long gid) throws Exception {
        return goodsDAO.    findById(gid);
    }

    @Override
    public Map<String, Object> findSubtypeIdGoods(Long stid , Long currentPage, Integer lineSize, String column, String keyWord , int delflag) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        if(column == null || keyWord == null || "".equals(column) || "".equals(keyWord)) {
            map.put("allGoods",goodsDAO.findSplitFlagAndStid(stid,currentPage,lineSize,delflag)) ;
            map.put("allRecorders",goodsDAO.getAllCountFlagAndStid(stid,delflag)) ;
        }else {
            map.put("allGoods",goodsDAO.findSplitFlagAndStid(stid,currentPage,lineSize,column,keyWord,delflag)) ;
            map.put("allRecorders",goodsDAO.getAllCountFlagAndStid(stid,column,keyWord,delflag)) ;
        }
        return map;
    }
}
