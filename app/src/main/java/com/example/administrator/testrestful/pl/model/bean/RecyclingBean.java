package com.example.administrator.testrestful.pl.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 回收专区
 */

public class RecyclingBean implements Serializable{
    private String title;
    private String img;
    private List<RecycleDataBean> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<RecycleDataBean> getData() {
        return data;
    }

    public void setData(List<RecycleDataBean> data) {
        this.data = data;
    }
}
