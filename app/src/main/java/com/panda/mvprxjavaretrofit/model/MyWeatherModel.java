package com.panda.mvprxjavaretrofit.model;

import com.panda.mvprxjavaretrofit.beans.WeatherData;
import com.panda.mvprxjavaretrofit.utils.internet.UseRetrofit;



import java.util.List;


import io.reactivex.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PC on 2017/9/26.
 */

public class MyWeatherModel implements IWeatherModel {


    CallBackModel  callBackModel;
    public MyWeatherModel( CallBackModel callBackModel)
    {
        this.callBackModel=callBackModel;
    }




    @Override
    public Disposable getWeatherData() {

        Observable<List<WeatherData>> observable= UseRetrofit.getObservable();

        Disposable sub=observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<WeatherData>>() {
                    @Override
                    public void accept(List<WeatherData> weatherDatas) throws Exception {
                        callBackModel.onSuccess(weatherDatas);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return sub;
    }
}
