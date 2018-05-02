package com.example.administrator.testrestful.pl.model;

import android.os.Environment;

import com.example.administrator.testrestful.pl.api.DownloadApi;
import com.example.administrator.testrestful.pl.config.DownloadApiEntity;
import com.example.administrator.testrestful.pl.download.CustomizeException;
import com.example.administrator.testrestful.pl.listener.ResponseListener;
import com.example.administrator.testrestful.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 文件下载
 * Created by pl on 2018/5/2 0002.
 */

public class DownloadModel extends BaseModel {
    public Disposable download(String url, ResponseListener<File> listener) {
        final File outputFile = new File(Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_DOWNLOADS), "file.apk");

        if (outputFile.exists()) {
            outputFile.delete();
        }

        return onResponseListener(((DownloadApi) getRequest(new DownloadApiEntity(), DownloadApi.class)).download(url)
                .subscribeOn(Schedulers.io())
                .map(new Function<ResponseBody, Object>() {
                    @Override
                    public File apply(ResponseBody responseBody) {
                        InputStream inputStream = responseBody.byteStream();
                        try {
                            FileUtils.writeFile(inputStream, outputFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new CustomizeException(e.getMessage(), e);
                        }
                        return outputFile;
                    }
                }).observeOn(Schedulers.computation()), listener);

    }
}
