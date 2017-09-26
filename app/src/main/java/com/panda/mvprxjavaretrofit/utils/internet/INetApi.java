package com.panda.mvprxjavaretrofit.utils.internet;

import com.panda.mvprxjavaretrofit.beans.WeatherData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by PC on 2017/9/26.
 */

public interface INetApi {

    @GET("api/china")
    Observable<List<WeatherData>> getWData();
}
