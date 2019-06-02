package com.yootk.drp.vo;

import java.sql.Date;

/**
 * 用户沟通记录
 */
public class CustomerRecord {
    private Long crid ; //客户联系记录的id
    private String cmid ; //客户的用户id（member 表的 mid）
    private Date cdate ; //客户联系日期
    private Long criid ; //联系类型
    private String note ; //信息记录
    private Long cuid ; //客户的编号（customer 表的 cuid）

    public CustomerRecord() {
    }

    public CustomerRecord(Long crid, String cmid, Date cdate, Long criid, String note, Long cuid) {
        this.crid = crid;
        this.cmid = cmid;
        this.cdate = cdate;
        this.criid = criid;
        this.note = note;
        this.cuid = cuid;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "crid=" + crid +
                ", cmid='" + cmid + '\'' +
                ", cdate=" + cdate +
                ", criid=" + criid +
                ", note='" + note + '\'' +
                ", cuid=" + cuid +
                '}';
    }

    public Long getCrid() {
        return crid;
    }

    public void setCrid(Long crid) {
        this.crid = crid;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Long getCriid() {
        return criid;
    }

    public void setCriid(Long criid) {
        this.criid = criid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }
}
