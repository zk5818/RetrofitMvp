package com.kery.rxmvp.manager;

import com.kery.rxmvp.moudle.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kery.rxmvp.moudle.Api.BASE_URL2;

/**
 * Author: TFJ
 * Date: 2017/10/12.
 */

public class Retrofit2Manager {

    private static Retrofit2Manager retrofit2Manager;
    private static final String BASE_URL = Api.BASE_URL;
    private static final int Time_Out = 10;
    private static Retrofit retrofit;
    private static Retrofit retrofit1;

    private Retrofit2Manager() {
    }

    public static Retrofit2Manager getInstance() {
        if (retrofit2Manager == null) {
            synchronized (Retrofit2Manager.class) {
                if (retrofit2Manager == null) {
                    retrofit2Manager = new Retrofit2Manager();
                }
            }
        }
        return retrofit2Manager;
    }

    public <T> T create(Class<T> clazz) {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkhttpClient())
                    .baseUrl(BASE_URL)
                    .build();
        return retrofit.create(clazz);
    }
    public <T> T create2(Class<T> clazz) {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkhttpClient())
                    .baseUrl(BASE_URL2)
                    .build();
        return retrofit.create(clazz);
    }
//    public <T> T create(Class<T> clazz, int type) {
//        if (retrofit1 == null)
//            retrofit1 = new Retrofit.Builder()
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .client(getOkhttpClient())
//                    .baseUrl(BASE_URL_ZRF)
//                    .build();
//        return retrofit1.create(clazz);
//    }

    private OkHttpClient getOkhttpClient() {
//        SSLSocketFactory sslSocketFactory = new SslContextFactory().getSslSocket().getSocketFactory();
//        OkHttpClient.Builder builder = new OkHttpClient.Builder().sslSocketFactory(sslSocketFactory);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Time_Out, TimeUnit.SECONDS);
        builder.readTimeout(Time_Out, TimeUnit.SECONDS);
        builder.writeTimeout(Time_Out, TimeUnit.SECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        return builder.build();
    }

}
