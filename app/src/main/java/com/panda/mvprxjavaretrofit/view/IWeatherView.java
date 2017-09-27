package com.panda.mvprxjavaretrofit.view;

import com.panda.mvprxjavaretrofit.beans.WeatherData;

import java.util.List;

/**
 * Created by PC on 2017/9/26.
 */

public interface IWeatherView {

    void showProgress();
    void hideProgress();
    void getWeatherData(List<WeatherData> weatherData);
}
