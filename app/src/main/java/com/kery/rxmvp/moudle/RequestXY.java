package com.kery.rxmvp.moudle;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author: TFJ
 * Date: 2017/10/12.
 */

public interface RequestXY {

//    @POST(Api.TEST_URL)
//    Observable<ResponseInfo<List<TestBean>>> getTestData(@Query("lng") String lng, @Query("lat") String lat);
//
//    @GET(Api.TEST_URL)
//    Observable<ResponseInfo<TestBean>> getTest();

    //    @GET(Api.TEST_URL)
//    Observable<ResponseInfo<TestBean>> getTestUU();
    @GET(Api.TEST_URL)
    Observable<ResponseBody> getTestUU();

    @GET(Api.TEST_URL2)
    Observable<ResponseBody> getTestPP();

    //http://192.168.43.173/api/trades/{userId}
    @GET(Api.BASE_URL2 + "/{userId}")
    Observable<ResponseBody> gethh(@Path("userId") String user_id);

    //http://192.168.43.173/api/trades?userId={用户id}
    @GET("trades")
    Call<ResponseBody> getItem(@Query("userId") String userId);

    //http://192.168.43.173/api/trades?userId={用户id}&type={类型}
    @GET("trades")
    Call<ResponseBody> getItem(
            @Query("userId") String userId,
            @QueryMap Map<String, Object> map);


    //http://192.168.43.173/api/trades/{userId}  需要补全URL,post的数据只有一条reason
    @FormUrlEncoded
    @POST("trades/{userId}")
    Call<ResponseBody> postResult(
            @Path("userId") String userId,
            @Field("reason") String reason);

    //http://192.168.43.173/api/trades/{userId}?token={token}
//需要补全URL,问号后需要加token,post的数据只有一条reason
    @FormUrlEncoded
    @POST("trades/{userId}")
    Call<ResponseBody> postResult(
            @Path("userId") String userId,
            @Query("token") String token,
            @Field("reason") String reason);






















}