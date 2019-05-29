package com.yootk.drp.vo;

import java.io.Serializable;

/**
 * @Auther: LL
 * @Date: 2019/5/28 09:08
 * @Description: 商品二级分类、子分类
 *  stid,title,wiid
 */
public class Subtype implements Serializable {
    private Long stid ;         //子分类编号，自动增长
    private String title ;      //子分类名称
    private Long wiid ;         //该子分类对应的分类的编号

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getWiid() {
        return wiid;
    }

    public void setWiid(Long wiid) {
        this.wiid = wiid;
    }
}
