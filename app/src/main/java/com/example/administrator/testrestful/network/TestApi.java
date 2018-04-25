package com.example.administrator.testrestful.network;


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
 * Created by pl on 2018/4/20 0020.
 * 1、获取单条数据  参数是id  get    return:bean实体
 * 2、获取列表数据  get   return: list对象  results
 * 3、添加单条数据 post   return: {"createdAt":"2018-04-24 14:44:42","objectId":"8c5ddeddb6"}
 * 4、修改单条数据  put   return: updatedAt
 * 5、删除单条数据  delete  return {"msg":"ok"}
 */

public interface TestApi {
    String HOST = "https://api.bmob.cn/1/";

    @GET("classes/rentout_info/{objectId}")
    Observable<RentOutInfoBean> getData(@Path("objectId") String objectId);

    @GET("classes/rentout_info")
    Observable<ListObjectBean<RentOutInfoBean>> getListData();

    @POST("classes/rentout_info")
    Observable<TestBean> postData(@Body TestBean testBean);

    @PUT("classes/rentout_info/{objectId}")
    Observable<TestBean> putData(@Path("objectId") String objectId,@Body TestBean testBean);

    @DELETE("classes/rentout_info/{objectId}")
    Observable<TestBean> deleteData(@Path("objectId") String objectId);

    String getTableUrl();

}
