package com.example.admin.moni.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.moni.R;
import com.example.admin.moni.bean.GoodBean;
import com.example.admin.moni.bean.Shoping;
import com.example.admin.moni.presenter.ShopingPresenter;

import java.util.ArrayList;
import java.util.List;

public class ShopingActivity extends AppCompatActivity implements Shoping_Iview {
    private Button shoping_btn;
    private ShopingPresenter mPresenter;
    private int mI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        mI = Integer.parseInt(pid);
        initViews();
        mPresenter = new ShopingPresenter(this);
    }

    private void initViews () {
        shoping_btn = findViewById(R.id.shoping_btn);
        shoping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getDatas(mI);
            }
        });
    }

    @Override
    public void viewsuccess(final Shoping shoping) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ShopingActivity.this,shoping.getMsg().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShopingActivity.this, CarActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void viewfail(int code) {

    }
}
