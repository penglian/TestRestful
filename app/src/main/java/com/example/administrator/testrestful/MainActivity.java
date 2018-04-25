package com.example.administrator.testrestful;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.testrestful.api.RentOutApi;
import com.example.administrator.testrestful.model.bean.ListObjectBean;
import com.example.administrator.testrestful.model.bean.RentOutInfoBean;
import com.example.administrator.testrestful.network.RetrofitCreateHelper;
import com.example.administrator.testrestful.network.RxHelper;
import com.example.administrator.testrestful.network.TestApi;
import com.example.administrator.testrestful.network.TestBean;
import com.example.administrator.testrestful.network.TestParentBean;
import com.example.administrator.testrestful.utils.ToastUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGet;
    Button btnPost;
    Button btnPut;
    Button btnDelete;
    Button btnGetList;
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
        tvResult = findViewById(R.id.tv_result);

        btnGet.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnGetList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String objectId = "8c5ddeddb6";
        switch (v.getId()) {
            case R.id.btn_get:
                rxManager.register(RetrofitCreateHelper.createApi(RentOutApi.class, RentOutApi.HOST).getData(objectId)
                        .compose(RxHelper.<RentOutInfoBean>rxSchedulerHelper()).subscribe(new Consumer<RentOutInfoBean>() {
                            @Override
                            public void accept(RentOutInfoBean result) throws Exception {
                                if (result != null) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(result.getObjectId() + ":" + result.getCity() + ":" + result.getContent() + "\n");
                                    tvResult.setText(sb.toString());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtil.showLong(MainActivity.this, throwable.toString());
                                tvResult.setText(throwable.toString());
                            }
                        }));
                break;
            case R.id.btn_get_list:
                rxManager.register(RetrofitCreateHelper.createApi(RentOutApi.class, RentOutApi.HOST)
                        .getListData().compose(RxHelper.<ListObjectBean<RentOutInfoBean>>rxSchedulerHelper())
                        .subscribe(new Consumer<ListObjectBean<RentOutInfoBean>>() {
                            @Override
                            public void accept(ListObjectBean<RentOutInfoBean> result) throws Exception {
                                if (result != null) {
                                    List<RentOutInfoBean> rentOutInfoBeans = result.getResults();
                                    if (rentOutInfoBeans != null && rentOutInfoBeans.size() > 0) {
                                        StringBuilder sb = new StringBuilder();
                                        for (RentOutInfoBean rentOutInfoBean : rentOutInfoBeans) {
                                            sb.append(rentOutInfoBean.getObjectId() + ":" + rentOutInfoBean.getCity() + ":" + rentOutInfoBean.getContent() + "\n");
                                        }
                                        tvResult.setText(sb.toString());
                                    }
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtil.showLong(MainActivity.this, throwable.toString());
                                tvResult.setText(throwable.toString());
                            }
                        }));
                break;
            case R.id.btn_post:
                RentOutInfoBean testBean = new RentOutInfoBean();
                testBean.setLastTime("131241341");
                testBean.setContent("13413411314ssa3");
                testBean.setCity("哈尔滨");
                rxManager.register(RetrofitCreateHelper.createApi(RentOutApi.class, RentOutApi.HOST).postData(testBean)
                        .compose(RxHelper.<RentOutInfoBean>rxSchedulerHelper()).subscribe(new Consumer<RentOutInfoBean>() {
                            @Override
                            public void accept(RentOutInfoBean result) throws Exception {
                                if (result != null) {
                                    tvResult.setText(result.getObjectId());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtil.showLong(MainActivity.this, throwable.toString());
                                tvResult.setText(throwable.toString());
                            }
                        }));
                break;
            case R.id.btn_put:
                final RentOutInfoBean testBean1 = new RentOutInfoBean();
                testBean1.setCity("上海");
                rxManager.register(RetrofitCreateHelper.createApi(RentOutApi.class, RentOutApi.HOST).putData(objectId, testBean1)
                        .compose(RxHelper.<RentOutInfoBean>rxSchedulerHelper()).subscribe(new Consumer<RentOutInfoBean>() {
                            @Override
                            public void accept(RentOutInfoBean result) throws Exception {
                                if (result != null) {
                                    tvResult.setText(result.getUpdatedAt());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtil.showLong(MainActivity.this, throwable.toString());
                                tvResult.setText(throwable.toString());
                            }
                        }));
                break;
            case R.id.btn_delete:
                rxManager.register(RetrofitCreateHelper.createApi(RentOutApi.class, RentOutApi.HOST).deleteData(objectId)
                        .compose(RxHelper.<RentOutInfoBean>rxSchedulerHelper()).subscribe(new Consumer<RentOutInfoBean>() {
                            @Override
                            public void accept(RentOutInfoBean result) throws Exception {
                                if (result != null) {
                                    tvResult.setText(result.getMsg());
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                ToastUtil.showLong(MainActivity.this, throwable.toString());
                                tvResult.setText(throwable.toString());
                            }
                        }));
                break;
        }
    }
}
