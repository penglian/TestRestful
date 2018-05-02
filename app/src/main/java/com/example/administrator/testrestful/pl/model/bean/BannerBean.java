package com.example.administrator.testrestful.pl.model.bean;

import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 轮播图
 */

public class BannerBean extends BaseBean {
    private String name;    //名称
    private List<String> content;   //图片数组

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
