package com.example.admin.moni.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {
    private static OkHttpClient client = null;
    public OkHttpUtils(){

    }

    public static OkHttpClient getInstance(){
        if (client == null){
            synchronized (OkHttpUtils.class){
                if (client == null){
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }

    public static void doGet(String url, Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }
}
