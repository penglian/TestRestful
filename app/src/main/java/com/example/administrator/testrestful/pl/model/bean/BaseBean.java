package com.example.administrator.testrestful.pl.model.bean;

import java.io.Serializable;

/**
 * Created by pl on 2018/4/24 0024.
 * 实体基类
 */

public class BaseBean implements Serializable{
    private String objectId;
    private String ALC;
    private String createdAt;  //创建时间
    private String updatedAt;  //更新时间
    private String msg;   //用于判断删除结果的

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getALC() {
        return ALC;
    }

    public void setALC(String ALC) {
        this.ALC = ALC;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
