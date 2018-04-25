package com.example.administrator.testrestful.model.bean;

import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 出租信息
 */

public class RentOutInfoBean extends BaseBean {
    private String fromwho;  //发布出租用户
    private String city;   //发布者所在城市
    private boolean isRentout; //是否已出租
    private List<String> image;  //图片数组
    private String price;  //出租价格
    private String origin_price;  //原价格
    private String icon;  //头像
    private String fishpond; //所属鱼塘
    private String content;  //出租内容描述
    private String lastTime;  //最近来过
    private TagBean tag;  //用户标识

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public String getFromwho() {
        return fromwho;
    }

    public void setFromwho(String fromwho) {
        this.fromwho = fromwho;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isRentout() {
        return isRentout;
    }

    public void setRentout(boolean rentout) {
        isRentout = rentout;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(String origin_price) {
        this.origin_price = origin_price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFishpond() {
        return fishpond;
    }

    public void setFishpond(String fishpond) {
        this.fishpond = fishpond;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public TagBean getTag() {
        return tag;
    }

    public void setTag(TagBean tag) {
        this.tag = tag;
    }
}
