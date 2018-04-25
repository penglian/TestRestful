package com.example.administrator.testrestful.utils;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * 图片工具类
 */
public class ImageUtil {
    private static final String TAG = ImageUtil.class.getSimpleName();

    /**
     * 通过图片Uri获取路径
     *
     * @param context 上下文
     * @param uri     图片Uri，eg:打开相册选取图片返回的Uri
     * @return 图片路径
     */
    public static String getImagePathFromUri(Context context, Uri uri) {
        String urlStr;
        if (Build.VERSION.SDK_INT >= 19) {
            // 4.4以上
            urlStr = handleImageOnKitKat(context, uri);
        } else {//老版本
            // 4.4以下
            urlStr = handleImageBeforeKitKat(context, uri);
        }
        return urlStr;
    }

    /**
     * 将图片转为Base64格式字符串
     *
     * @param imagePath 图片路径
     * @return Base64格式字符串
     */
    public static String getImageDataBase64(String imagePath) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BitmapFactory.decodeFile(imagePath).compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return "data:image/jpg;base64," + new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static String handleImageOnKitKat(Context context, Uri uri) {
        // 如果不是document类型的Uri，则通过document id处理
        String imagePath = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1]; // 解析出数字格式的id
                String selection = Media._ID + "=" + id;
                imagePath = getImagePath(context, Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(context, contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // 如果不是document类型的Uri，则使用普通方式处理
            imagePath = getImagePath(context, uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // 如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        if (imagePath == null) {
            imagePath = uri.getPath();
        }
        return imagePath;
    }

    private static String handleImageBeforeKitKat(Context context, Uri uri) {
        return getImagePath(context, uri, null);
    }

    private static String getImagePath(Context context, Uri uri, String selection) {
        String path = null;
        try {
            Cursor cursor = context.getContentResolver().query(uri, null, selection, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    path = cursor.getString(cursor.getColumnIndex(Media.DATA));
                }
                cursor.close();
            }
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            path = null;
        }
        if (path == null) { // 有些手机上面的方法会报错，使用这个从网上查到的方法可行
            try {
                Cursor cursor = context.getContentResolver().query(uri,
                        new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
                if (null != cursor) {
                    if (cursor.moveToFirst()) {
                        int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                        if (index > -1) {
                            path = cursor.getString(index);
                        }
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                path = null;
            }
        }
        return path;
    }
}
