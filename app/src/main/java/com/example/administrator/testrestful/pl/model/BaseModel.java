package com.example.administrator.testrestful.pl.model;

import com.example.administrator.testrestful.pl.manager.NetworkManager;
import com.example.administrator.testrestful.pl.RxHelper;
import com.example.administrator.testrestful.pl.config.BaseApiEntity;
import com.example.administrator.testrestful.pl.listener.ResponseListener;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Model层基类
 * Created by pl on 2018/4/28 0028.
 */

public abstract class BaseModel<T, K> {

    /**
     * 请求回调
     * @param observable
     * @param listener
     * @return
     */
    protected Disposable onResponseListener(Observable<T> observable, final ResponseListener listener) {
        return observable.compose(RxHelper.<T>rxSchedulerHelper()).subscribe(new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                listener.onSuccess(t);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                listener.onFailed(throwable);
            }
        });
    }

    /**
     * 获取接口类
     * @param baseApiEntity
     * @param clazz
     * @return
     */
    public K getRequest(BaseApiEntity baseApiEntity, Class<K> clazz) {
        return NetworkManager.getInstance()
                .doRequest(baseApiEntity, clazz);
    }
}
