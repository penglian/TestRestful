package com.example.administrator.testrestful.pl.model.bean;

/**
 * Created by pl on 2018/4/24 0024.
 * 启动广告接口
 */

public class LaunchADBean extends BaseBean {
    private String clickUrl;   //点击跳转链接
    private String content;   //广告显示链接
    private int duration;    //广告显示时间
    private boolean isShow;  //是否显示广告
    private String type;  //广告类型

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
