package com.example.admin.moni.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.admin.moni.R;
import com.example.admin.moni.adapter.CarAdapter;
import com.example.admin.moni.bean.CarBean;
import com.example.admin.moni.presenter.CarPresenter;

import java.util.List;

public class CarActivity extends AppCompatActivity implements Car_Iview {
    private ExpandableListView car_expanable;
    private CarPresenter mPresenter;
    private List<CarBean.DataBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        initViews();
        mPresenter = new CarPresenter(this);
        mPresenter.getDatas();
    }

    private void initViews() {
        car_expanable = findViewById(R.id.car_expanable);

    }

    @Override
    public void viewsuccess(CarBean carBean) {
        mData = carBean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CarAdapter carAdapter = new CarAdapter(CarActivity.this, mData);
                car_expanable.setAdapter(carAdapter);
                int count = car_expanable.getCount();
                for (int i = 0; i < count; i++) {
                    car_expanable.expandGroup(i);
                }
            }
        });
    }

    @Override
    public void viewfail(int code) {

    }
}
