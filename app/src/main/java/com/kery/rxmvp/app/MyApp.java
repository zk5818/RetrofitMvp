package com.kery.rxmvp.app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Author: TFJ
 * Date: 2017/10/11.
 */

public class MyApp extends Application {

    private static Context context;
    private static Toast toast;
    /**
     * 手机状态栏高度
     */
    public static int mStatusHeight = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    public static Context getContext() {
        return context;
    }

    public static void showToast(String msg) {
        if (msg == null) msg = "";
        toast.setText(msg);
        toast.show();
    }
}
