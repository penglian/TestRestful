package com.example.administrator.testrestful.pl;

import android.content.Context;

/**
 * Application中init初始化类
 *
 * Created by pl on 2018/4/26 0026.
 */

public class RytApp {
    private static Context context;

    public static void init(Context mContext){
        context = mContext.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
