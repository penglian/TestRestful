package com.example.administrator.testrestful.api;

import com.example.administrator.testrestful.model.bean.ListObjectBean;
import com.example.administrator.testrestful.model.bean.RentOutInfoBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by pl on 2018/4/24 0024.
 * 出租接口类
 */

public interface RentOutApi{
    String HOST = "https://api.bmob.cn/1/classes/";
    String TABLE_URL = "rentout_info";

    @GET(TABLE_URL + "/{objectId}")
    Observable<RentOutInfoBean> getData(@Path("objectId") String objectId);

    @GET(TABLE_URL)
    Observable<ListObjectBean<RentOutInfoBean>> getListData();

    @POST(TABLE_URL)
    Observable<RentOutInfoBean> postData(@Body RentOutInfoBean rentOutInfoBean);

    @PUT(TABLE_URL + "/{objectId}")
    Observable<RentOutInfoBean> putData(@Path("objectId") String objectId, @Body RentOutInfoBean rentOutInfoBean);

    @DELETE(TABLE_URL + "/{objectId}")
    Observable<RentOutInfoBean> deleteData(@Path("objectId") String objectId);
}
