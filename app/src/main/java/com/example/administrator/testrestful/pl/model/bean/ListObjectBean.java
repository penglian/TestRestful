package com.example.administrator.testrestful.pl.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pl on 2018/4/24 0024.
 * 列表数据的包裹
 */

public class ListObjectBean<T> implements Serializable{
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
