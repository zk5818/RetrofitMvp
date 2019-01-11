package com.kery.rxmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Kery on 2018/12/7.
 */
public class RecycleNormal extends RecyclerView {
    public RecycleNormal(@NonNull Context context) {
        super(context);
        this.setLayoutManager(new LinearLayoutManager(context));
    }
}
