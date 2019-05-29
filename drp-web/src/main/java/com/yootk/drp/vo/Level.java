package com.yootk.drp.vo;

public class Level {
    private Long lid ;
    private String title ;

    public Level(Long lid) {
        this.lid = lid;
    }

    public Level(Long lid, String title) {
        this.lid = lid;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Level{" +
                "lid=" + lid +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getLid() {
        return lid;
    }

    public void setid(Long lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
