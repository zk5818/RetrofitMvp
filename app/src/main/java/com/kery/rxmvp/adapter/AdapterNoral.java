package com.kery.rxmvp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Kery on 2018/12/6.
 */
public abstract class AdapterNoral<T> extends BaseQuickAdapter {
    private Context mContext;

    public AdapterNoral(Context context, int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        this.mContext = context;
    }

//    List<T> data = new ArrayList<>();

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Object o) {
        convertData(baseViewHolder, (T) o);

    }


    public abstract void convertData(BaseViewHolder baseViewHolder, T s);


//
//    public void setOnItemClickNormal(BaseQuickAdapter.OnItemChildClickListener s) {
//    }

//    @Override
//    public void setOnItemClick(View v, int position) {
//        super.setOnItemClick(v, position);
//        Log.e("setOnItemClick","点击了第"+position+"个");
////        setOnItemClickNormal(v, position);
//    }



}
