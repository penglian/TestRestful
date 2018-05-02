package com.example.administrator.testrestful.pl.model;

import com.example.administrator.testrestful.pl.api.RentOutApi;
import com.example.administrator.testrestful.pl.listener.ResponseListener;
import com.example.administrator.testrestful.pl.model.bean.RentOutInfoBean;
import com.example.administrator.testrestful.pl.config.CommonApiEntity;

import io.reactivex.disposables.Disposable;


/**
 * 房屋出租model
 * Created by pl on 2018/4/28 0028.
 */

public class RentOutModel extends BaseModel {
    public Disposable getData(String objectId, ResponseListener<RentOutInfoBean> listener) {
        return onResponseListener(((RentOutApi) getRequest(new CommonApiEntity(), RentOutApi.class))
                .getData(objectId), listener);
    }

}
