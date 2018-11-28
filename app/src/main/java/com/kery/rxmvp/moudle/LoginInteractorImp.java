package com.kery.rxmvp.moudle;

import android.content.Context;
import android.util.Log;

import com.kery.rxmvp.bean.RequestCode;
import com.kery.rxmvp.manager.Retrofit2Manager;
import com.kery.rxmvp.presenter.prelinster.LoginPresenter;
import com.kery.rxmvp.presenter.presenterImp.LoginPresenterImp;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Kery on 2018/11/28.
 */
public class LoginInteractorImp extends BaseModule implements LoginInteractor {
    private Context mContext;
    private LoginPresenter mPresenter;


    public LoginInteractorImp(Context context, LoginPresenterImp presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
        mRequestXY = Retrofit2Manager.getInstance().create(RequestXY.class);
        //如果有2个不同域名的请求方式，需要重新顶一个Retrofit2Manager
//        mRequestXY2 = Retrofit2Manager.getInstance().create2(RequestXY.class);
    }


    @Override
    public void getUserInfo() {
        doRequestXY(RequestCode.dog, mRequestXY.getTestUU());
        doRequestXY(RequestCode.ox, mRequestXY.getTestUU());
    }


    @Override
    protected void onNext(ResponseBody data, RequestCode requestCode) {
        try {
            Log.e(requestCode.name(),new String(data.bytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (requestCode) {
            case dog:
                try {
                    mPresenter.setName(new String(data.bytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
