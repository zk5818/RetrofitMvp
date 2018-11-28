package com.kery.rxmvp.manager;


import rx.Subscriber;

/**
 * Author: TFJ
 * Date: 2017/10/12.
 */

public class MySubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
//        LogUtil.i("onStart被调用了");
    }

    @Override
    public void onCompleted() {
//        LogUtil.i("onCompleted被调用了");
    }

    @Override
    public void onError(Throwable e) {
//        LogUtil.e("onError被调用了");
//        LogUtil.i(e.getMessage());
    }

    @Override
    public void onNext(T t) {
//        LogUtil.i("onNext被调用了");
    }


}
