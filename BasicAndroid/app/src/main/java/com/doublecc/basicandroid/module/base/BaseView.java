package com.doublecc.basicandroid.module.base;

import com.doublecc.basicandroid.bean.BeanBeauty;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BaseView {

    void onFailure(String message);

    interface main extends BaseView{
        void onSuccessInfo(List<BeanBeauty> list);
    }
}
