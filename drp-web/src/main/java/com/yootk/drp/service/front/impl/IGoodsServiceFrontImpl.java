package com.yootk.drp.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.drp.dao.ISubtypeDAO;
import com.yootk.drp.dao.IWitemDAO;
import com.yootk.drp.service.front.IGoodsServiceFront;

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

    @Override
    public Map<String, Object> findSubtypeAndWitem() throws Exception {
        Map<String, Object> map = new HashMap<>() ;
        map.put("allSubtype" ,subtypeDao.findAll()) ;
        map.put("allWitem",witemDao.findAll()) ;
        return map;
    }
}
