package com.example.admin.moni.model;

import com.example.admin.moni.bean.CarBean;
import com.example.admin.moni.bean.Shoping;
import com.example.admin.moni.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author:admin
 * Date:2018-7-28 16:14
 * Project：Moni
 */
public class CarModel {
    private String url ="http://www.zhaoapi.cn/product/getCarts?uid=71";
    public void getData(final Car_Imodel car_imodel){
        OkHttpUtils.doGet(url , new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                car_imodel.modelfail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                CarBean carBean = new Gson().fromJson(json, CarBean.class);
                car_imodel.modelsuccess(carBean);
            }
        });
    }
}
