package com.kery.rxmvp.bean;

/**
 * Author: TFJ
 * Date: 2017/10/11.
 */

public enum RequestCode {
    first, refresh, more,       //列表加载的不同情况
    first1, refresh1, more1,    //列表加载的不同情况
    error,                 //比较特殊的错误情况,用于错误回调
    rat, ox, tiger, hare, dragon, snake, horse, sheep, monkey, cock, dog, boar  //十二生肖 用于标记一个页面的不同请求
}
