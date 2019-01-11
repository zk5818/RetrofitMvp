package com.kery.rxmvp.moudle;


import com.kery.rxmvp.bean.RequestCode;
import com.kery.rxmvp.bean.ResponseInfo;
import com.kery.rxmvp.manager.MySubscriber;
import com.kery.rxmvp.manager.RXManager;
import com.kery.rxmvp.manager.Retrofit2Manager;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscription;

/**
 * Author: TFJ
 * Date: 2017/10/12.
 */

public abstract class BaseModule {


    protected RequestXY mRequestXY;
//    protected RequestXY mRequestXY2;
    public Subscription doRequestXY(RequestCode requestCode,Observable observable) {
//        mRequestXY = Retrofit2Manager.getInstance().create(RequestXY.class);
        return execute(requestCode,observable);
    }

    private Subscription execute(final RequestCode requestCode, Observable observable) {
        return RXManager.getInstance().doSubscribe(observable, new MySubscriber<ResponseBody>() {
            @Override
            public void onNext(ResponseBody tResponseInfo) {
                super.onNext(tResponseInfo);
//                if (tResponseInfo.flag.equals("1")) {
//                    LogUtil.d("解析成功 格式正确 flag == 1 数据正常 !");
                    BaseModule.this.onNext(tResponseInfo, requestCode);
//                } else {
                    //返回数据格式正确,但flag显示不是正确想要的数据(一般msg中会给出错误情况)
//                    LogUtil.e("解析成功 格式正确 flag != 1 无正常数据 !   ------------" + requestCode);
//                    BaseModule.this.onError(tResponseInfo.msg, requestCode);
//                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);//直接请求错误,根本没有拿到 ResponseInfo<T> 格式数据, 基本断定为网络错误或解析格式错误
//                mView.analyzeError(requestCode);
            }
        });
    }


//    protected abstract Observable<ResponseInfo<T>> getObservable(RequestCode requestCode);

    /**
     * 请求获取到了数据,但服务器返回数据显示不是成功数据
     */
//    protected void onError(String msg, RequestCode requestCode) {
//        mView.onError(requestCode, msg);
//    }

    protected abstract void onNext(ResponseBody responseBody, RequestCode requestCode);
}
