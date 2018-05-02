package com.example.administrator.testrestful.pl.model.bean;

import java.io.Serializable;

/**
 * Created by pl on 2018/4/24 0024.
 * 用户标识
 */

public class TagBean implements Serializable{
    private int type;
    private int level;
    private String desc;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
