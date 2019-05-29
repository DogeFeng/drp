package com.yootk.drp.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: LL
 * @Date: 2019/5/28 13:55
 * @Description:
 * mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid
 */
public class Member implements Serializable {
    private String mid ;    //雇员或用户的ID，雇员是由后台管理员负责的，而用户是由前台自己注册的
    private Long lid ;      //对应等级编号
    private Long did ;      //对应部门编号
    private String name ;   //用户或雇员的真实姓名
    private double sal ;    //基本工资
    private String phone ;  //联系电话
    private String password ;
    private String photo;
    private String note ;   //用户的信息备注，可以在后台添加时填写
    private Date regdate ;  //注册日期，而如果是雇员就是雇佣日期
    private String inmid ;  //添加此雇员的用户编号
    private int locked ;    //锁定标记。0：未锁定、1：已锁定
    private int type ;      //用户类型。0：前端用户、1：后台雇员
    private String email ;  //用户的注册邮箱
    private Long cuid ;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Long getLid() {
        return lid;
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

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
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

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCuid() {
        return cuid;
    }

    public void setCuid(Long cuid) {
        this.cuid = cuid;
    }
}
