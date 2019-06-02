package com.yootk.drp.vo;

import java.io.Serializable;

public class Dept implements Serializable {
    private Long did ;
    private String dname ;
    private String mid ;

    public Dept() {
    }

    public Dept(Long did, String dname, String mid) {
        this.did = did;
        this.dname = dname;
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", mid='" + mid + '\'' +
                '}';
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
