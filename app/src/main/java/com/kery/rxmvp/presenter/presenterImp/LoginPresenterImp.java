package com.kery.rxmvp.presenter.presenterImp;

import android.content.Context;

import com.kery.rxmvp.moudle.LoginInteractor;
import com.kery.rxmvp.moudle.LoginInteractorImp;
import com.kery.rxmvp.presenter.prelinster.LoginPresenter;
import com.kery.rxmvp.view.LoginView;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kery on 2018/11/28.
 */
public class LoginPresenterImp extends BasePresenterImp implements LoginPresenter {
    private LoginView mLoginView;
    private LoginInteractor mInteractor;

    public LoginPresenterImp(Context context, LoginView view) {
        super(context, view);
        this.mLoginView = view;
        this.mContext = context;
        mInteractor = new LoginInteractorImp(mContext, this);
    }

    @Override
    public void getLogin() {
        mInteractor.getUserInfo();
    }

    @Override
    public void setName(String name) {
        mLoginView.showData(name);
    }

    @Override
    public void responseSuccess(Object response, String tag, String operate) {

    }

    @Override
    public void responseError(Request request, Response response, Exception e, String tag, String operate) {

    }

    @Override
    public void networkError(Request request, Exception e, String tag) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
