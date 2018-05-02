package com.example.administrator.testrestful.pl.api;

import com.example.administrator.testrestful.pl.model.bean.ListObjectBean;
import com.example.administrator.testrestful.pl.model.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * 用户接口类
 */

public interface UserApi{
    String TABLE_URL = "_User";

    @GET(TABLE_URL + "/{objectId}")
    Observable<UserBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<UserBean>> getListData();

    @POST(TABLE_URL)
    Observable<UserBean> postData(@Body UserBean userBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<UserBean> putData(@Path("objectId") String objectId, @Body UserBean userBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<UserBean> deleteData(@Path("objectId") String objectId);
}
