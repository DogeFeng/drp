package com.yootk.drp.vo;

/**
 * 客户回访业务分类
 */
public class CRItem {
    private Long criid ;
    private String title ;

    public CRItem() {
    }

    public CRItem(Long criid) {
        this.criid = criid;
    }

    public CRItem(String title) {
        this.title = title;
    }

    public CRItem(Long criid, String title) {
        this.criid = criid;
        this.title = title;
    }

    @Override
    public String toString() {
        return "CrItem{" +
                "criid=" + criid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getCriid() {
        return criid;
    }

    public void setCriid(Long criid) {
        this.criid = criid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
