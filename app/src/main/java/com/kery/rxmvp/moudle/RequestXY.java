package com.kery.rxmvp.moudle;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
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

}
