package com.example.administrator.testrestful.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * 系统工具类
 */
public class SystemUtil {
    private static final String TAG = SystemUtil.class.getSimpleName();

    private static String mVersionName = "";
    private static int mVersionCode = 0;

    /**
     * 获取应用版本名
     */
    public static String getVersionName(Context context) {
        if (TextUtils.isEmpty(mVersionName)) {
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                mVersionName = info.versionName;
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
            }
        }
        return mVersionName;
    }

    /**
     * 获取应用版本号
     */
    public static int getVersionCode(Context context) {
        if (mVersionCode == 0) {
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                mVersionCode = info.versionCode;
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
            }
        }
        return mVersionCode;
    }

}
