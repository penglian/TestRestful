package com.example.administrator.testrestful.api;

import com.example.administrator.testrestful.model.bean.ListObjectBean;
import com.example.administrator.testrestful.model.bean.RentOutGridInfoBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * 出租页面Api
 */

public interface RentOutGridApi{
    String HOST = "https://api.bmob.cn/1/classes/";
    String TABLE_URL = "rentout_grid_info";

    @GET(TABLE_URL + "/{objectId}")
    Observable<RentOutGridInfoBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<RentOutGridInfoBean>> getListData();

    @POST(TABLE_URL)
    Observable<RentOutGridInfoBean> postData(@Body RentOutGridInfoBean rentOutGridInfoBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<RentOutGridInfoBean> putData(@Path("objectId") String objectId, @Body RentOutGridInfoBean rentOutGridInfoBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<RentOutGridInfoBean> deleteData(@Path("objectId") String objectId);
}
