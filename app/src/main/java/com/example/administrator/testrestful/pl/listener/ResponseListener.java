package com.example.administrator.testrestful.pl.listener;


/**
 * 请求结果回调响应
 * Created by pl on 2018/4/28 0028.
 */

public interface ResponseListener<T> {
    void onSuccess(T t);
    void onFailed(Throwable throwable);
}
