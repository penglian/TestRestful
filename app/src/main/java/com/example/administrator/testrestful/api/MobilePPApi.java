package com.example.administrator.testrestful.api;

import com.example.administrator.testrestful.model.bean.ListObjectBean;
import com.example.administrator.testrestful.model.bean.MobilePPBean;
import com.example.administrator.testrestful.network.TestBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * 手机产品参数
 */

public interface MobilePPApi{
    String HOST = "https://api.bmob.cn/1/classes/";
    String TABLE_URL = "mobile_pp";

    @GET(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<MobilePPBean>> getListData();

    @POST(TABLE_URL)
    Observable<MobilePPBean> postData(@Body TestBean testBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> putData(@Path("objectId") String objectId, @Body TestBean testBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> deleteData(@Path("objectId") String objectId);
}
