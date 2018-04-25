package com.example.administrator.testrestful.network.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 针对bomb云平台自定义header拦截器
 * Created by pl on 2018/4/20 0020.
 */

public class HeaderInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Bmob-Application-Id", "b889bc2b481df2eb0cc509274e18b931")
                .addHeader("X-Bmob-REST-API-Key", "c82f22d9f2f0b95c9feb48910046a644")
                .build();
        return chain.proceed(request);
    }
}
