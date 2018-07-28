package com.example.admin.moni.model;

import android.util.Log;

import com.example.admin.moni.bean.GoodBean;
import com.example.admin.moni.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author:admin
 * Date:2018-7-28 9:59
 * Project：Moni
 */
public class ShowModel {
    private static final String TAG = "ShowModel";
    private String url = "http://www.zhaoapi.cn/product/searchProducts?keywords=";
    private String url01 = "&page=";
    private String url02 = "&sort=";
    public void getdata(final Show_Imodel show_imodel, String keywords, int page, int sort){
        OkHttpUtils.doGet(url + keywords + url01 + page + url02 + sort, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "model: 失败");
                show_imodel.modelfail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "model: 成功");
                String json = response.body().string();
                GoodBean goodBean = new Gson().fromJson(json, GoodBean.class);
                show_imodel.modelsuccess(goodBean);
            }
        });
    }
}
