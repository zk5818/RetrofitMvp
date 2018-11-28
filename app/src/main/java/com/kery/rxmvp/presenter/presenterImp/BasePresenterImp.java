package com.kery.rxmvp.presenter.presenterImp;

import android.content.Context;
import android.content.Intent;

import com.kery.rxmvp.presenter.prelinster.BasePresenter;
import com.kery.rxmvp.view.BaseView;


import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jason.huang on 2016/8/11 0011.
 */
public abstract class BasePresenterImp implements BasePresenter {
    protected Context mContext;
    protected BaseView IView;


    public BasePresenterImp(Context context) {
        this.mContext = context;
    }

    public BasePresenterImp(Context context, BaseView view) {
        this.mContext = context;
        this.IView = view;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void success(Object response, String tag, String operate) {
        boolean isDestroyed = false;
        //判断页面是否销毁
        if (IView.isActivityDestroy()) {
            return;
        }

        if (response == null) {
            return;
        }

        responseSuccess(response, tag, operate);
    }

    @Override
    public void error(Request request, Response response, Context context, Exception e, String tag, String
            operate) {
        hideLoading();
//        if (e.getStackTrace()[0].getClassName().equals(OkHttpUtils.NETWORK_CONNETION_FAIL)) {
//            T.showShort(mContext, mContext.getString(R.string.network_anomaly));
//            networkError(request, e, tag);
//        } else if (response != null && response.code() == StatusConfig.CODE_INVALID_TOKEN) {
//            responseError(request, response, e, tag, operate);
//            SPHelper.clearToLogin(context);
//            skipLogin(context);
//        } else {
//            responseError(request, response, e, tag, operate);
//        }
    }


    @Override
    public void inProgress(int progress) {
        progress(progress);
    }

    public void progress(int progress) {

    }



    public abstract void responseSuccess(Object response, String tag, String operate);

    public abstract void responseError(Request request, Response response, Exception e, String tag, String operate);

    public abstract void networkError(Request request, Exception e, String tag);

    public abstract void showLoading();

    public abstract void hideLoading();
}
