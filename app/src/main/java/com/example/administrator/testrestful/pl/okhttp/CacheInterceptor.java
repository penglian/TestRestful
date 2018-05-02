package com.example.administrator.testrestful.pl.okhttp;

import com.example.administrator.testrestful.pl.RytApp;
import com.example.administrator.testrestful.utils.NetworkConnectionUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.administrator.testrestful.utils.HttpUtils.getUserAgent;

/**
 * 缓存拦截器
 * Created by pl on 2017/9/12.
 */
public class CacheInterceptor implements Interceptor {
    private int maxAge;// 有网络时, 缓存1小时
    private int maxStale; // 无网络时，缓存为4周
    public CacheInterceptor(int maxAge, int maxStale){
         this.maxAge = maxAge;
         this.maxStale = maxStale;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (NetworkConnectionUtils.isNetworkConnected(RytApp.getContext())) {
            request = request.newBuilder()
                    .removeHeader("User-Agent")
                    .header("User-Agent", getUserAgent())
                    .build();

            Response response = chain.proceed(request);
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .removeHeader("User-Agent")
                    .header("User-Agent", getUserAgent())
                    .build();

            Response response = chain.proceed(request);
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }
}
