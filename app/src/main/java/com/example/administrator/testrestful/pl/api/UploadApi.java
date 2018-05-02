package com.example.administrator.testrestful.pl.api;

import com.example.administrator.testrestful.pl.model.bean.UploadBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


/**
 * Created by pl on 2018/4/26 0026.
 * 可以使用@part来传递content
 */

public interface UploadApi {

    @Multipart
    @POST("files/{filename}")
    Observable<UploadBean> uploadImage(@Part MultipartBody.Part file, @Path("filename") String filename);
}
