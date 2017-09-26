package com.panda.mvprxjavaretrofit.model;

import com.panda.mvprxjavaretrofit.beans.WeatherData;

import java.util.List;

/**
 * Created by PC on 2017/9/26.
 */

public interface CallBackModel {

    void onSuccess(List<WeatherData> weatherDatas);
}
