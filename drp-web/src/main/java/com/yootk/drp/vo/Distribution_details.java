package com.yootk.drp.vo;

import java.io.Serializable;

public class Distribution_details implements Serializable {
    private Long dsdid;
    private Long dsid;
    private Long gid;
    private String name;
    private Integer num;
    private Double price;
    private Integer status;
    private Long wid;
    private String outmid;
    private Long cuid;

    @Override
    public String toString() {
        return "Distribution_details{" +
                "dsdid=" + dsdid +
                ", dsid=" + dsid +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", status=" + status +
                ", wid=" + wid +
                ", outmid='" + outmid + '\'' +
                ", cuid=" + cuid +
                '}';
    }

    public Long getDsdid() {
        return dsdid;
    }

    public void setDsdid(Long dsdid) {
        this.dsdid = dsdid;
    }

    public Long getDsid() {
        return dsid;
    }

    public void setDsid(Long dsid) {
        this.dsid = dsid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getOutmid() {
        return outmid;
    }

    public void setOutmid(String outmid) {
        this.outmid = outmid;
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }
}
