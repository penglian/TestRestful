package com.example.administrator.testrestful.utils;

import android.util.Log;

/**
 * 日志工具类。
 */
public class LogUtil {
    private static final String TAG = "PhoneRent";
    private static final boolean isDeveloper = true;

    public static void v(String from, String msg) {
        if (isDeveloper) {
            Log.v(TAG, from + ":" + msg);
        }
    }

    public static void d(String from, String msg) {
        if (isDeveloper) {
            Log.d(TAG, from + ":" + msg);
        }
    }

    public static void i(String from, String msg) {
        if (isDeveloper) {
            Log.i(TAG, from + ":" + msg);
        }
    }

    public static void w(String from, String msg) {
        if (isDeveloper) {
            Log.w(TAG, from + ":" + msg);
        }
    }

    public static void e(String from, String msg) {
        if (isDeveloper) {
            Log.e(TAG, from + ":" + msg);
        }
    }
}
