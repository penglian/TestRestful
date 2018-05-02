package com.example.administrator.testrestful.pl.config;


/**
 * 普通请求  一般只需要配置url
 * Created by pl on 2018/4/26 0026.
 */

public class CommonApiEntity extends BaseApiEntity{
    public CommonApiEntity() {
        setBaseUrl("https://api.bmob.cn/1/classes/");
    }
}
