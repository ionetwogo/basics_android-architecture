package com.doublecc.basicandroid.module.base;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BaseView {

    void onFailure();

    interface main extends BaseView{
        void onSuccessInfo();
    }
}
