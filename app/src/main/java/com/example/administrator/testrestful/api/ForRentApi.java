package com.example.administrator.testrestful.api;

import com.example.administrator.testrestful.model.bean.ForRentInfoBean;
import com.example.administrator.testrestful.model.bean.ListObjectBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * 求租接口类
 */

public interface ForRentApi{
    String HOST = "https://api.bmob.cn/1/classes/";
    String TABLE_URL = "forrent_info";

    @GET(TABLE_URL + "/{objectId}")
    Observable<ForRentInfoBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<ForRentInfoBean>> getListData();

    @POST(TABLE_URL)
    Observable<ForRentInfoBean> postData(@Body ForRentInfoBean forRentInfoBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<ForRentInfoBean> putData(@Path("objectId") String objectId, @Body ForRentInfoBean forRentInfoBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<ForRentInfoBean> deleteData(@Path("objectId") String objectId);
}
