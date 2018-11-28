package com.kery.rxmvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kery.rxmvp.R;
import com.kery.rxmvp.presenter.prelinster.LoginPresenter;
import com.kery.rxmvp.presenter.presenterImp.LoginPresenterImp;
import com.kery.rxmvp.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.tv)
    TextView textView;

    LoginPresenter mLoginPresenter;

    @OnClick(R.id.button)
    public void onButterKnifeBtnClick(View view) {
        switch (view.getId()) {
            case R.id.button:

                mLoginPresenter.getLogin();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImp(getApplicationContext(), this);
    }

    @Override
    public void showData(String n) {
        textView.setText(n);
    }

    @Override
    public boolean isActivityDestroy() {
        return false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetworkError() {

    }
}