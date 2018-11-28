package com.kery.rxmvp.view;

/**
 * Created by jason.huang on 2016/7/7 0007.
 */
public interface BaseView {
    boolean isActivityDestroy();

    void showLoading();

    void hideLoading();

    void showNetworkError();


}
