package com.example.administrator.testrestful.pl.model.bean;

import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 出租页面数据
 */

public class RentOutGridInfoBean extends BaseBean {
    private List<String> TypeGrid;
    private List<String> Recommend;  //猎奇捡漏数据
    private String name;  //不同区域数据
    private String searchText;  //搜索框文本
    private RecyclingBean Recycling; //回收专区

    public List<String> getTypeGrid() {
        return TypeGrid;
    }

    public void setTypeGrid(List<String> typeGrid) {
        TypeGrid = typeGrid;
    }

    public List<String> getRecommend() {
        return Recommend;
    }

    public void setRecommend(List<String> recommend) {
        Recommend = recommend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public RecyclingBean getRecycling() {
        return Recycling;
    }

    public void setRecycling(RecyclingBean recycling) {
        Recycling = recycling;
    }
}
