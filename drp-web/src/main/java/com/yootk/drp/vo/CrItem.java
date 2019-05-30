package com.yootk.drp.vo;

/**
 * 客户回访业务分类
 */
public class CrItem {
    private Long criid ;
    private String title ;

    public CrItem(Long criid) {
        this.criid = criid;
    }

    public CrItem(String title) {
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
