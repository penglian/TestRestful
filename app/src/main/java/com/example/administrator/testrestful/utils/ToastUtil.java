package com.example.administrator.testrestful.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static void showShort(Context context, String info) {
        if (context != null) {
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLong(Context context, String info) {
        if (context != null) {
            Toast.makeText(context, info, Toast.LENGTH_LONG).show();
        }
    }
}
