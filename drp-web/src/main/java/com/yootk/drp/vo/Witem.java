package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:25
 * @Description: 商品一级分类
 */
public class Witem implements Serializable {
    private Long wiid ;     //分类编号，自动增长
    private String title ;  //分类名称

    public Long getWiid() {
        return wiid;
    }

    public void setWiid(Long wiid) {
        this.wiid = wiid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
