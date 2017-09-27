package com.panda.mvprxjavaretrofit.presenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by PC on 2017/9/27.
 */

public class BasePresenter {


    //将所有正在处理的Subscription都添加到CompositeDisposable中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;

    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    public void addDisposable(Disposable subscription){

        if (mCompositeDisposable==null||mCompositeDisposable.isDisposed()) {
            mCompositeDisposable=new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);

    }

    //注销所有请求
    public void unDisposable(){
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


}
