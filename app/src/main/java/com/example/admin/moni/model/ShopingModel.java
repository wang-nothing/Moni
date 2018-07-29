package com.example.admin.moni.model;

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
public class ShopingModel {
    private String url ="http://www.zhaoapi.cn/product/addCart?uid=71&pid=";
    public void getData(final Shoping_Imodel shoping_imodel, int pid){
        OkHttpUtils.doGet(url + pid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                shoping_imodel.modelfail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Shoping shoping = new Gson().fromJson(json, Shoping.class);
                shoping_imodel.modelsuccess(shoping);
            }
        });
    }
}
