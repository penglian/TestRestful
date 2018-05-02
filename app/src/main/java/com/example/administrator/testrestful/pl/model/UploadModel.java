package com.example.administrator.testrestful.pl.model;

import com.example.administrator.testrestful.pl.api.UploadApi;
import com.example.administrator.testrestful.pl.listener.ResponseListener;
import com.example.administrator.testrestful.pl.model.bean.UploadBean;
import com.example.administrator.testrestful.pl.config.UploadApiEntity;

import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

/**
 * 图片上传model
 * Created by pl on 2018/4/28 0028.
 */

public class UploadModel extends BaseModel {
    public Disposable uploadFile(MultipartBody.Part part, String fileName, ResponseListener<UploadBean> listener) {
        return onResponseListener(((UploadApi) getRequest(new UploadApiEntity(), UploadApi.class))
                .uploadImage(part, fileName), listener);
    }
}
