package com.example.administrator.testrestful.pl.api;

import com.example.administrator.testrestful.pl.model.bean.ListObjectBean;
import com.example.administrator.testrestful.pl.model.bean.MobilePPBean;

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

public interface MobilePPApi {
    String TABLE_URL = "mobile_pp";

    @GET(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<MobilePPBean>> getListData();

    @POST(TABLE_URL)
    Observable<MobilePPBean> postData(@Body MobilePPBean testBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> putData(@Path("objectId") String objectId, @Body MobilePPBean testBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<MobilePPBean> deleteData(@Path("objectId") String objectId);
}
