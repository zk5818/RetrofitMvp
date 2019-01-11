package com.kery.rxmvp.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kery.rxmvp.R;

import java.util.List;

/**
 * Created by Kery on 2018/12/7.
 */
public class ItemDraggableAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {

    public ItemDraggableAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_1, item);
    }
}
