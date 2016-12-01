package com.doublecc.basicandroid.module.base;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BasePresenter {

    interface mainPresenter{
        void requestData(String url,int number, int page);
    }
    interface beautyPresenter{
        void requestData(String url,int number, int page);
    }
}
