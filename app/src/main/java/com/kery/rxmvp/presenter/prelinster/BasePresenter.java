package com.kery.rxmvp.presenter.prelinster;

import android.content.Context;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kery on 2018/11/28.
 */
public interface BasePresenter {
    void initialize();

    void success(Object response, String tag, String operate);

    void error(Request request, Response response, Context context, Exception e, String tag, String operate);

    void inProgress(int progress);

    void showLoading();

    void hideLoading();
}

