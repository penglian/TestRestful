package com.example.administrator.testrestful.model.bean;

/**
 * Created by pl on 2018/4/24 0024.
 * 求组信息表
 */

public class ForRentInfoBean extends BaseBean{
     private String city;   //求租发布城市
     private String fromwho; //求租发布用户
     private String price;  //求租价格
     private String content;  //求租内容描述

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFromwho() {
        return fromwho;
    }

    public void setFromwho(String fromwho) {
        this.fromwho = fromwho;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
