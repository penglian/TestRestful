package com.example.administrator.testrestful.pl.download;

/**
 * 下载进度listener
 * Created by pl on 16/5/11.
 */
public interface DownloadProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}
