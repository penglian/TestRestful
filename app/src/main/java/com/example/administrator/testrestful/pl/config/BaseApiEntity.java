package com.example.administrator.testrestful.pl.config;

import com.example.administrator.testrestful.utils.AppUtils;

import java.io.File;

import okhttp3.Cache;

/**
 * 基础请求信息配置
 * Created by pl on 2018/4/26 0026.
 */

public abstract class BaseApiEntity {
    private String baseUrl;  //基地址

    private boolean isDebug = true;
    private int maxAge = 60 * 60;  //网络时缓存
    private int maxStale = 60 * 60 * 24 * 28;  //无网络时缓存

    private int timeOutRead = 20;     //读取超时
    private int timeOutConnection = 10;  //连接超时

    private boolean isBombServer = true; //是否是Bomb

    private int diskCacheMaxSize = 50 * 1024 * 1024;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * 构建磁盘缓存
     *
     * @return
     */
    public Cache getCache() {
        return new Cache(new File(AppUtils.getContext().getCacheDir().getAbsolutePath() + File
                .separator + "data/NetCache"),
                diskCacheMaxSize);
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public int getTimeOutRead() {
        return timeOutRead;
    }

    public void setTimeOutRead(int timeOutRead) {
        this.timeOutRead = timeOutRead;
    }

    public int getTimeOutConnection() {
        return timeOutConnection;
    }

    public void setTimeOutConnection(int timeOutConnection) {
        this.timeOutConnection = timeOutConnection;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public boolean isBombServer() {
        return isBombServer;
    }

    public void setBombServer(boolean bombServer) {
        isBombServer = bombServer;
    }

    public int getMaxStale() {
        return maxStale;
    }

    public void setMaxStale(int maxStale) {
        this.maxStale = maxStale;
    }
}
