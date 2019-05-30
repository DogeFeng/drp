package com.yootk.drp.service.front;

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
    public Map<String,Object> findSubtypeAndWitem() throws Exception ;
}
