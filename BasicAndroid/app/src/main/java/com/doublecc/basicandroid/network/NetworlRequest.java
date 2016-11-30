package com.doublecc.basicandroid.network;

import rx.Subscriber;

/**
 * Created by DoubleCC on 2016/11/30 0030.
 */

public class NetworlRequest {

    public static void executeGetRequest(String url, int number, int page, Subscriber subscriber){
        GankApiService apiService = RetrofitClient.createService(GankApiService.class);
        RetrofitClient.execute(apiService.getBeauties(url,number,page),subscriber);
    }
}
