package com.example.administrator.testrestful.pl.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by pl on 2018/5/2 0002.
 */

public interface DownloadApi {
    //下载的文件很大,则使用@Streaming
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);
}
