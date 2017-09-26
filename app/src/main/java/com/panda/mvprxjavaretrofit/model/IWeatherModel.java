package com.panda.mvprxjavaretrofit.model;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by PC on 2017/9/26.
 */

public interface IWeatherModel {

//        接口rx.Subscription负责流和资源的生命周期管理，即退订和释放资源
        Disposable getWeatherData();
}
