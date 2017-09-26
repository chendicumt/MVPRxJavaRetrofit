package com.panda.mvprxjavaretrofit.utils.internet;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.panda.mvprxjavaretrofit.beans.WeatherData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 2017/9/26.
 */

public class UseRetrofit {


    public static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://guolin.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    static INetApi iNetApi=retrofit.create(INetApi.class);

//    Observable<List<WeatherData>> observable=iNetApi.getWData();

    public static Observable<List<WeatherData>> getObservable() {
        return iNetApi.getWData();
    }
}
