package com.yootk.drp.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 客户信息表单
 */
public class Customer implements Serializable {
    private Long cuid ; //客户信息编号
    private String name ; //客户真实姓名
    private String phone ;
    private Long pid ; //省份id
    private Long cid ; //城市id
    private String address ; //客户地址，包含省份和城市信息
    private Date indate ; //录入日期
    private Integer connum ; //客户联系次数
    private Long ciid ; //客户等级编号
    private Long csid ; //客户来源编号
    private String note ; //客户信息记录
    private String recorder ; //客户信息记录者 雇员的mid
    private Integer status ; //认证状态

    public Customer() {
    }

    public Customer(Long cuid, String name, String phone, Long pid, Long cid, String address, Date indate, Integer connum, Long ciid, Long csid, String note, String recorder, Integer status) {
        this.cuid = cuid;
        this.name = name;
        this.phone = phone;
        this.pid = pid;
        this.cid = cid;
        this.address = address;
        this.indate = indate;
        this.connum = connum;
        this.ciid = ciid;
        this.csid = csid;
        this.note = note;
        this.recorder = recorder;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cuid=" + cuid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", address='" + address + '\'' +
                ", indate=" + indate +
                ", connum=" + connum +
                ", ciid=" + ciid +
                ", csid=" + csid +
                ", note='" + note + '\'' +
                ", recorder='" + recorder + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Integer getConnum() {
        return connum;
    }

    public void setConnum(Integer connum) {
        this.connum = connum;
    }

    public Long getCiid() {
        return ciid;
    }

    public void setCiid(Long ciid) {
        this.ciid = ciid;
    }

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
