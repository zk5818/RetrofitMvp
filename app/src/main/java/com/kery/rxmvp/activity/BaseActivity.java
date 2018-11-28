package com.kery.rxmvp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kery.rxmvp.R;
import com.kery.rxmvp.app.MyApp;
import com.kery.rxmvp.bean.state;

import butterknife.ButterKnife;

/**
 * Created by Kery on 2018/11/28.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public FrameLayout getContainer() {
        return mContainer;
    }

    private FrameLayout mContainer;
    private View mNone;
    private View mError;
    private View mLoad;
    protected View mRootView;
    private state mState = state.complete;
    private ImageView mLoagGif;

    public void setNeedStatusBar(boolean needStatusBar) {
        this.needStatusBar = needStatusBar;
    }

    private boolean needStatusBar = true;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_view);
        mContainer = (FrameLayout) findViewById(R.id.container);
        LayoutInflater inflater = LayoutInflater.from(this);
        mRootView = inflater.inflate(initLayoutId(), null);
        ButterKnife.bind(this, mRootView);
        mContainer.addView(mRootView);
//        setStatusBar();

        mNone = inflater.inflate(R.layout.view_empty, null);
        mError = inflater.inflate(R.layout.view_error, null);
        mLoad = inflater.inflate(R.layout.view_loading, null);
        mContainer.addView(mNone);
        mContainer.addView(mError);
        mContainer.addView(mLoad);
        mNone.setVisibility(View.GONE);
        mError.setVisibility(View.GONE);
        mLoad.setVisibility(View.GONE);

//        RelativeLayout windowsManager = (RelativeLayout) mInflater.inflate(
//                R.layout.windows_manager, null);//为整个activity的布局
//        windowsManager .addView(fakeTitleContainer);

        initView();
        /*---------要求子类布局中必须有一个id是status_bar用于占去状态栏的位置-------
        ---------如果不需要请在initView()方法中调用setNeedStatusBar(false)--------*/
        if (needStatusBar)
            setStatusBarHight((LinearLayout) mRootView.findViewById(R.id.status_bar));
        initData();
        addLisenter();


        mLoagGif = (ImageView) mLoad.findViewById(R.id.load_gif);
    }

    protected abstract int initLayoutId();

    private void addLisenter() {

    }

    protected abstract void initView();

    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        MyApp.getRefWatcher().watch(this);
    }

    public void setState(state state) {
        mState = state;
        refreshState();
    }

    public state getState() {
        return mState;
    }

    private void refreshState() {
        switch (mState) {
            case loading:
                mLoad.setVisibility(View.VISIBLE);
//                Glide.with(this).load(R.drawable.loading).into(mLoagGif);
                break;
            case error:
                mLoagGif.setImageDrawable(null);
                mLoad.setVisibility(View.GONE);
                mError.setVisibility(View.VISIBLE);
                break;
            case empty:
                mLoagGif.setImageDrawable(null);
                mLoad.setVisibility(View.GONE);
                mError.setVisibility(View.GONE);
                mNone.setVisibility(View.VISIBLE);
                break;
            case complete:
                mLoagGif.setImageDrawable(null);
                mLoad.setVisibility(View.GONE);
                mError.setVisibility(View.GONE);
                mNone.setVisibility(View.GONE);
                mRootView.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    public void setStatusBarHight(LinearLayout linear_bar) {
        linear_bar.setVisibility(View.INVISIBLE);
        linear_bar.setBackgroundColor(Color.TRANSPARENT);
        //动态的设置隐藏布局的高度  ☆☆☆☆☆☆外层布局必须是 LinearLayout   ☆☆☆☆☆☆☆☆☆
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear_bar.getLayoutParams();
        params.height = MyApp.mStatusHeight;
        linear_bar.setLayoutParams(params);
    }

}
