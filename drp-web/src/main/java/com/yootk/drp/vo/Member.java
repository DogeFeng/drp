package com.yootk.drp.vo;

import java.util.Date;

public class Member {
    private String mid ;
    private Long lid ;
    private Long did ;
    private String name ;
    private Double sal ;
    private String phone ;
    private String password ;
    private String photo ;
    private String note ;
    private Date regdate ;
    private String inmid ;
    private Integer locked ;
    private Integer type ;
    private String email ;

    public Member() {
    }

    public Member(String mid, Long lid, Long did, String name, Double sal, String phone, String password, String photo, String note, Date regdate, String inmid, Integer locked, Integer type, String email) {
        this.mid = mid;
        this.lid = lid;
        this.did = did;
        this.name = name;
        this.sal = sal;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
        this.note = note;
        this.regdate = regdate;
        this.inmid = inmid;
        this.locked = locked;
        this.type = type;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", lid=" + lid +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", note='" + note + '\'' +
                ", regdate=" + regdate +
                ", inmid='" + inmid + '\'' +
                ", locked=" + locked +
                ", type=" + type +
                ", email='" + email + '\'' +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Long getLid(){
        return this.lid ;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getInmid() {
        return inmid;
    }

    public void setInmid(String inmid) {
        this.inmid = inmid;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
