package com.yootk.drp.vo;

/**
 * 记录客户来源
 */
public class CSource {
    private Long csid ;
    private String title ;

    public CSource(Long csid) {
        this.csid = csid;
    }

    public CSource(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CSource{" +
                "csid=" + csid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
