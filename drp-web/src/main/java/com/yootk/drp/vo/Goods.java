package com.yootk.drp.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: LL
 * @Date: 2019/5/28 08:59
 * @Description: 商品信息
 *  gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag
 */
public class Goods implements Serializable {
    private Long gid ;          //商品编号，自动增长
    private String name ;       //商品名称
    private Long wiid ;         //商品对应的分类
    private Long stid ;         //商品对应的子分类
    private double price ;      //商品价格
    private double weight ;     //商品重量
    private String photo ;      //商品的图片内容
    private String note ;       //商品信息描述
    private Date lastin ;       //最后一次进货时间
    private int stornum ;       //商品的整体存储数量
    private String recorder ;   //商品信息记录的用户id
    private int delflag ;       //删除标记。0：未删除、1：已删除

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

    public Long getWiid() {
        return wiid;
    }

    public void setWiid(Long wiid) {
        this.wiid = wiid;
    }

    public Long getStid() {
        return stid;
    }

    public void setStid(Long stid) {
        this.stid = stid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public Date getLastin() {
        return lastin;
    }

    public void setLastin(Date lastin) {
        this.lastin = lastin;
    }

    public int getStornum() {
        return stornum;
    }

    public void setStornum(int stornum) {
        this.stornum = stornum;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", wiid=" + wiid +
                ", stid=" + stid +
                ", price=" + price +
                ", weight=" + weight +
                ", photo='" + photo + '\'' +
                ", note='" + note + '\'' +
                ", lastin=" + lastin +
                ", stornum=" + stornum +
                ", recorder='" + recorder + '\'' +
                ", delflag=" + delflag +
                '}';
    }
}