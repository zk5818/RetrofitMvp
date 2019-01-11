package com.kery.rxmvp.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.kery.rxmvp.R;
import com.kery.rxmvp.adapter.AdapterNoral;
import com.kery.rxmvp.adapter.ItemDraggableAdapter;
import com.kery.rxmvp.presenter.prelinster.LoginPresenter;
import com.kery.rxmvp.presenter.presenterImp.LoginPresenterImp;
import com.kery.rxmvp.view.LoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.tv)
    TextView textView;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    LoginPresenter mLoginPresenter;
    boolean flag;

    @OnClick({R.id.button, R.id.button1})
    public void onButterKnifeBtnClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                mLoginPresenter.getLogin();
                break;

            case R.id.button1:
//                if (flag)
//                    adapterNoral.remove(1);
//                else
                adapterNoral.addData("打开水大卡司");
                flag = !flag;
                break;
        }
    }

    private ItemDraggableAdapter itemDraggableAdapter;
    AdapterNoral adapterNoral;
    BaseItemDraggableAdapter baseItemDraggableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImp(getApplicationContext(), this);

        recycle.setLayoutManager(new LinearLayoutManager(this));
//        adapterNoral = new AdapterNoral<String>(this, R.layout.item_recycle_normal, strings) {
//
//            @Override
//            public void convertData(BaseViewHolder baseViewHolder, String s) {
//                baseViewHolder.setText(R.id.tv_1, s);
//                baseViewHolder.addOnClickListener(R.id.tv_1);
//            }
//        };
//        adapterNoral.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                Log.e("---->", "点击了item：" + i);
//            }
//        });
//        adapterNoral.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                switch (view.getId()) {
//                    case R.id.tv_1:
//                        Log.e("---->", "点击了tv_1");
//                        break;
//                }
//            }
//        });
//
//        adapterNoral.openLoadAnimation();
        itemDraggableAdapter = new ItemDraggableAdapter(R.layout.item_recycle_normal, strings);
        itemDraggableAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        recycle.setAdapter(itemDraggableAdapter);

        ItemDragAndSwipeCallback itemDragAndSwipeCallback
                = new ItemDragAndSwipeCallback(itemDraggableAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recycle);

// 开启拖拽
        itemDraggableAdapter.enableDragItem(itemTouchHelper, R.id.tv_1, true);
        itemDraggableAdapter.setOnItemDragListener(onItemDragListener);

// 开启滑动删除
        itemDraggableAdapter.enableSwipeItem();
        itemDraggableAdapter.setOnItemSwipeListener(onItemSwipeListener);


    }



    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("-->", "你在拖拽第" + (pos + 1) + "个位置的item哦！");
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from,
                                     RecyclerView.ViewHolder target, int to) {

        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("-->", "拖拽到了第" + (pos + 1) + "个位置哦！");
        }
    };

    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("-->", "继续向右滑动即可删除第" + (pos + 1) + "个位置的item");
        }

        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {

        }

        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("-->", "删除了第" + (pos + 1) + "个位置的item哦");
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder,
                                      float dX, float dY, boolean isCurrentlyActive) {

        }
    };


    @Override
    public void showData(String n) {
        textView.setText(n);
    }

    @Override
    public boolean isActivityDestroy() {
        return false;
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    List<String> strings = new ArrayList<>();

    {
        strings.add("的卢萨卡就雷达技术");
        strings.add("；来我家看；来得及啊爱迪生");
        strings.add("打算大萨达as阿萨德 ");
        strings.add("2位我去请问请问请问");

    }

    @Override
    public void showNetworkError() {
//        BaseQuickAdapter baseQuickAdapter = new BaseQuickAdapter(R.layout.action_bar, strings) {
//            @Override
//            protected void convert(BaseViewHolder baseViewHolder, Object o) {
////                baseViewHolder.set
//            }
//        };


    }


}