package com.example.administrator.testrestful;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.testrestful.pl.listener.ResponseListener;
import com.example.administrator.testrestful.pl.manager.RxManager;
import com.example.administrator.testrestful.pl.model.DownloadModel;
import com.example.administrator.testrestful.pl.model.RentOutModel;
import com.example.administrator.testrestful.pl.model.UploadModel;
import com.example.administrator.testrestful.pl.model.bean.RentOutInfoBean;
import com.example.administrator.testrestful.pl.model.bean.UploadBean;
import com.example.administrator.testrestful.utils.ToastUtil;

import java.io.File;
import java.util.List;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGet;
    Button btnPost;
    Button btnPut;
    Button btnDelete;
    Button btnGetList;
    Button btnUpload;
    Button btnDownload;
    TextView tvResult;
    RxManager rxManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        rxManager = new RxManager();
    }

    private void initView() {
        btnGet = findViewById(R.id.btn_get);
        btnPost = findViewById(R.id.btn_post);
        btnPut = findViewById(R.id.btn_put);
        btnDelete = findViewById(R.id.btn_delete);
        btnGetList = findViewById(R.id.btn_get_list);
        btnUpload = findViewById(R.id.btn_upload);
        btnDownload = findViewById(R.id.btn_download);
        tvResult = findViewById(R.id.tv_result);

        btnDownload.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
        btnGet.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnGetList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String objectId = "52396a5b6d";
        switch (v.getId()) {
            case R.id.btn_get:
                //1、请求参数配置 （如果是普通请求或者图片上传与文件下载，则无需配置）
                //2、api接口与model层配置，如果存在则无需配置
                //3、调用回调
                RentOutModel rentOutModel = new RentOutModel();
                rxManager.register(rentOutModel.getData(objectId, new ResponseListener<RentOutInfoBean>() {
                    @Override
                    public void onSuccess(RentOutInfoBean rentOutInfoBean) {
                        if (rentOutInfoBean != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(rentOutInfoBean.getObjectId() + ":" + rentOutInfoBean.getCity() + ":" + rentOutInfoBean.getContent() + "\n");
                            tvResult.setText(sb.toString());
                        }
                    }
                    @Override
                    public void onFailed(Throwable throwable) {
                        ToastUtil.showLong(MainActivity.this, throwable.toString());
                        tvResult.setText(throwable.toString());
                    }
                }));


                break;
            case R.id.btn_get_list:

                break;
            case R.id.btn_post:

                break;
            case R.id.btn_put:

                break;
            case R.id.btn_delete:

                break;
            case R.id.btn_upload:
                //图片上传
                MultiPicSelectActivity.launch(this, false, 1, 1, 1000);
                break;
            case R.id.btn_download:
                //文件下载
                String testUrl = "http://download.fir.im/v2/app/install/595c5959959d6901ca0004ac?download_token=1a9dfa8f248b6e45ea46bc5ed96a0a9e&source=update";
                DownloadModel downloadModel = new DownloadModel();
                rxManager.register(downloadModel.download(testUrl, new ResponseListener<File>() {
                    @Override
                    public void onSuccess(File file) {
                        ToastUtil.showLong(MainActivity.this, file.getName() + "\n" + file.length());
                        //包安装
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setDataAndType(TestFileProvider.getUriForFile(MainActivity.this, "com.example.administrator.testrestful", file), "application/vnd.android.package-archive");
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        ToastUtil.showLong(MainActivity.this, throwable.toString());
                    }
                }));
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (data == null) {
                return;
            }

            List<String> images = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            if (images != null && images.size() > 0) {
                //文件上传需要配置的参数
                File file = new File(images.get(0));
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                MultipartBody.Part part = MultipartBody.Part.create(requestBody);
                UploadModel uploadModel = new UploadModel();
                rxManager.register(uploadModel.uploadFile(part, file.getName(), new ResponseListener<UploadBean>() {
                    @Override
                    public void onSuccess(UploadBean uploadBean) {
                        if (uploadBean != null) {
                            tvResult.setText(uploadBean.getFilename() + "\n" + uploadBean.getUrl());
                        }
                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        ToastUtil.showLong(MainActivity.this, throwable.toString());
                        tvResult.setText(throwable.toString());
                    }
                }));

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rxManager.unSubscribe();
    }

}
