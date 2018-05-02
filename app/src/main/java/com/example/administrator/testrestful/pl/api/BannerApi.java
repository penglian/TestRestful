package com.example.administrator.testrestful.pl.api;

import com.example.administrator.testrestful.pl.model.bean.BannerBean;
import com.example.administrator.testrestful.pl.model.bean.ListObjectBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * Banner轮播图
 */

public interface BannerApi{
    String TABLE_URL = "Banner";

    @GET(TABLE_URL + "/{objectId}")
    Observable<BannerBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<BannerBean>> getListData();

    @POST(TABLE_URL)
    Observable<BannerBean> postData(@Body BannerBean bannerBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<BannerBean> putData(@Path("objectId") String objectId, @Body BannerBean bannerBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<BannerBean> deleteData(@Path("objectId") String objectId);
}
