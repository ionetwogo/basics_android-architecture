package com.doublecc.basicandroid.network;

import com.doublecc.basicandroid.bean.GankResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by DoubleCC on 2016/11/30 0030.
 */

public interface GankApiService {
    @GET("{url}/{number}/{page}")
    Observable<GankResult> getBeauties(@Path("url") String url, @Path("number") int number, @Path("page") int page);
}
