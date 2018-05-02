package com.example.administrator.testrestful.pl.model.bean;

import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 附近的出租信息
 */

public class GoodsListNearBy extends BaseBean {
     private String city;   //发布者所在城市
     private String price;  //出租价格
     private String orignal_price; //原价格
     private String lastTime;  //最近来过
     private boolean isRentout;  //是否已出租
     private List<String> image;  //图片数组
     private String icon;  //头像
     private String fromwho;  //出租发布用户
     private String fishpond; //所属鱼塘
     private String content;  //出租内容描述
     private TagBean tag;   //用户标识

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public String getPrice() {
          return price;
     }

     public void setPrice(String price) {
          this.price = price;
     }

     public String getOrignal_price() {
          return orignal_price;
     }

     public void setOrignal_price(String orignal_price) {
          this.orignal_price = orignal_price;
     }

     public String getLastTime() {
          return lastTime;
     }

     public void setLastTime(String lastTime) {
          this.lastTime = lastTime;
     }

     public boolean isRentout() {
          return isRentout;
     }

     public void setRentout(boolean rentout) {
          isRentout = rentout;
     }

     public List<String> getImage() {
          return image;
     }

     public void setImage(List<String> image) {
          this.image = image;
     }

     public String getIcon() {
          return icon;
     }

     public void setIcon(String icon) {
          this.icon = icon;
     }

     public String getFromwho() {
          return fromwho;
     }

     public void setFromwho(String fromwho) {
          this.fromwho = fromwho;
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

     public TagBean getTag() {
          return tag;
     }

     public void setTag(TagBean tag) {
          this.tag = tag;
     }
}
