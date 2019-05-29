package com.yootk.drp.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.drp.vo.Subtype;

import java.util.List;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:45
 * @Description:
 */
public interface ISubtypeDAO extends IBaseDAO<Long, Subtype> {

    public List<Subtype> findByWiid(Long wiid) throws Exception ;
}
