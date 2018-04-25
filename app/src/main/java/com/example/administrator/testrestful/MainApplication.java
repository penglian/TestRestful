package com.example.administrator.testrestful;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by pl on 2018/4/23 0023.
 */

public class MainApplication extends Application{
    protected static Context mContext;
    protected static Handler mHandler;
    protected static int mainThreadId;
    private static MainApplication mApp;

    public static synchronized MainApplication getInstance() {
        return mApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化捕获全局异常
        mContext = getApplicationContext();
        mHandler = new Handler();
        mainThreadId = android.os.Process.myTid();
        // 初始化 Bmob SDK
    }

    /**
     * 获取上下文对象
     * @return context
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 获取全局handler
     * @return 全局handler
     */
    public static Handler getHandler() {
        return mHandler;
    }

    /**
     * 获取主线程id
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
