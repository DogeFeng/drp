package com.yootk.drp.vo;

/**
 * 客户等级
 */
public class CItem {
    private Long ciid ;
    private String title ;

    public CItem() {
    }

    public CItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CItem{" +
                "ciid=" + ciid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getCiid() {
        return ciid;
    }

    public void setCiid(Long ciid) {
        this.ciid = ciid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
