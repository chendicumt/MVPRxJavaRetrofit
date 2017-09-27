package com.panda.mvprxjavaretrofit.presenter;

import com.panda.mvprxjavaretrofit.beans.WeatherData;
import com.panda.mvprxjavaretrofit.model.CallBackModel;
import com.panda.mvprxjavaretrofit.model.IWeatherModel;
import com.panda.mvprxjavaretrofit.model.MyWeatherModel;
import com.panda.mvprxjavaretrofit.view.IWeatherView;

import java.util.List;

/**
 * Created by PC on 2017/9/26.
 */

public class WeatherPresenter extends BasePresenter{

    IWeatherView iWeatherView;
    IWeatherModel iWeatherModel;



    public WeatherPresenter(IWeatherView iWeatherView)
    {
        this.iWeatherView=iWeatherView;
        iWeatherModel=new MyWeatherModel(callBackModel);
    }

    CallBackModel callBackModel=new CallBackModel() {
        @Override
        public void onSuccess(List<WeatherData> weatherDatas) {

            iWeatherView.hideProgress();
            iWeatherView.getWeatherData(weatherDatas);
        }
    };


    public void getWeatherData() {
        iWeatherView.showProgress();
        addDisposable(iWeatherModel.getWeatherData());
    }
}
