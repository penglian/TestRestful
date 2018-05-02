package com.example.administrator.testrestful.pl.model.bean;

import java.io.Serializable;

/**
 * Created by pl on 2018/4/24 0024.
 * 回收专区数据实体
 */

public class RecycleDataBean implements Serializable {
    private String desc;
    private String icon;
    private TagBean tag;

    private String tagColor;

    public TagBean getTag() {
        return tag;
    }

    public void setTag(TagBean tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTagColor() {
        return tagColor;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }
}
