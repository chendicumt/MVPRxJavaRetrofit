package com.panda.mvprxjavaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.panda.mvprxjavaretrofit.beans.WeatherData;
import com.panda.mvprxjavaretrofit.view.IWeatherView;

public class MainActivity extends AppCompatActivity implements IWeatherView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getWeatherData(WeatherData weatherData) {

    }
}
