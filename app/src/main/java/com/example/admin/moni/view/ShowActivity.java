package com.example.admin.moni.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.moni.MainActivity;
import com.example.admin.moni.R;
import com.example.admin.moni.adapter.RecyclerAdapter;
import com.example.admin.moni.bean.GoodBean;
import com.example.admin.moni.presenter.ShowPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener,Show_Iview {
    private ImageView show_image_back,show_iamge_search,show_image_del,show_image_list,show_image_grid;
    private TextView show_tv_zonghe,show_tv_xiaoliang,show_tv_jiage;
    private EditText show_et_search;
    private SmartRefreshLayout show_smart;
    private RecyclerView recyclerview;
    private String keywords = "手机";
    private int page = 1;
    private int sort = 0;
    private ShowPresenter mPresenter;
    private List<GoodBean.DataBean> mData;
    private RecyclerAdapter mAdapter;
    private String mTv_search;
    private String mPid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Fresco.initialize(this);
        initViews();
        initDatas();
        initeListenr();
        mPresenter = new ShowPresenter(this);
        mPresenter.getDatas(keywords, page, sort);

    }

    private void initeListenr() {
        show_image_back.setOnClickListener(this);
        show_iamge_search.setOnClickListener(this);
        show_image_del.setOnClickListener(this);
        show_image_list.setOnClickListener(this);
        show_image_grid.setOnClickListener(this);
        show_tv_zonghe.setOnClickListener(this);
        show_tv_jiage.setOnClickListener(this);
        show_tv_xiaoliang.setOnClickListener(this);
        show_smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getDatas(keywords, page, sort);
            }
        });
        show_smart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getDatas(keywords, page++, sort);
            }
        });
    }

    private void initDatas() {
        Intent intent = getIntent();
        String item_text = intent.getStringExtra("item_text");
        show_et_search.setText(item_text);
        keywords = item_text;
    }

    private void initViews() {
        show_image_back = findViewById(R.id.show_image_back);
        show_iamge_search = findViewById(R.id.show_iamge_search);
        show_image_del = findViewById(R.id.show_image_del);
        show_image_list = findViewById(R.id.show_image_list);
        show_image_grid = findViewById(R.id.show_image_grid);
        show_et_search = findViewById(R.id.show_et_search);
        show_smart = findViewById(R.id.show_smart);
        show_tv_zonghe = findViewById(R.id.show_tv_zonghe);
        show_tv_xiaoliang = findViewById(R.id.show_tv_xiaoliang);
        show_tv_jiage = findViewById(R.id.show_tv_jiage);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_image_back:
                finish();
                break;

            case R.id.show_iamge_search:
                mTv_search = show_et_search.getText().toString();
                keywords = mTv_search;
                mPresenter.getDatas(keywords, page, sort);
                break;

            case R.id.show_image_del:
                show_et_search.getText().clear();
                break;

            case R.id.show_image_list:
                recyclerview.setLayoutManager(new GridLayoutManager(this,2));
                show_image_list.setVisibility(View.INVISIBLE);
                show_image_grid.setVisibility(View.VISIBLE);
                break;

            case R.id.show_image_grid:
                recyclerview.setLayoutManager(new LinearLayoutManager(this));
                show_image_list.setVisibility(View.VISIBLE);
                show_image_grid.setVisibility(View.INVISIBLE);
                break;

            case R.id.show_tv_zonghe:
                sort = 0;
                mPresenter.getDatas(keywords, page, sort);
                break;

            case R.id.show_tv_xiaoliang:
                sort = 1;
                mPresenter.getDatas(keywords, page, sort);
                break;

            case R.id.show_tv_jiage:
                sort = 2;
                mPresenter.getDatas(keywords, page, sort);
                break;
        }
    }

    @Override
    public void viewsuccess(final GoodBean goodBean) {
        mData = goodBean.getData();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mAdapter = new RecyclerAdapter(ShowActivity.this, mData);
                mData.addAll(goodBean.getData());
                recyclerview.setAdapter(mAdapter);
                mAdapter.setOnItemclick(new RecyclerAdapter.onItemclick() {
                    @Override
                    public void itemclick(List<GoodBean.DataBean> mData) {
                        for (int i = 0; i < mData.size(); i++) {
                            mPid = mData.get(i).getPid();
                        }
                        Intent intent = new Intent(ShowActivity.this, ShopingActivity.class);
                        intent.putExtra("pid", mPid);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public void viewfail(int code) {

    }


}
