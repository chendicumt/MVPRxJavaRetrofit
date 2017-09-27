package com.panda.mvprxjavaretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.panda.mvprxjavaretrofit.beans.WeatherData;
import com.panda.mvprxjavaretrofit.presenter.WeatherPresenter;
import com.panda.mvprxjavaretrofit.view.IWeatherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IWeatherView{

    @BindView(R.id.text_view)
    TextView textView;
    ProgressDialog progressDialog;
    WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        weatherPresenter=new WeatherPresenter(this);
        weatherPresenter.getWeatherData();
    }


    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();

    }

    @Override
    public void getWeatherData(List<WeatherData> weatherData) {
        StringBuffer stringBuffer=new StringBuffer();

        for (int i=0;i<weatherData.size();i++) {
            stringBuffer.append(weatherData.get(i).getId()+weatherData.get(i).getName());
        }

        textView.setText(stringBuffer.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        取消注册
        weatherPresenter.unDisposable();
    }
}
