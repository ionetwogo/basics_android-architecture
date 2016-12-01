package com.doublecc.basicandroid.network;

import rx.Subscriber;

/**
 * Created by DoubleCC on 2016/11/30 0030.
 */

public class NetworlRequest {
    private static GankApiService apiService = RetrofitClient.createService(GankApiService.class);
    public static void executeGetBeauty(String url, int number, int page, Subscriber subscriber){
        RetrofitClient.execute(apiService.getBeauties(url,number,page),subscriber);
    }
    public static void executeGetTechnolgy(String url, int number, int page, Subscriber subscriber){
        RetrofitClient.execute(apiService.getTechnology(url,number,page),subscriber);
    }
}
