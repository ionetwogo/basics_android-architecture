package com.doublecc.basicandroid.module.base;

import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.bean.BeanTechnology;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BaseView {

    void onFailure(String message);

    interface main extends BaseView{
        void onSuccessInfo(List<BeanTechnology> list);
    }

    interface beauty extends BaseView{
        void onSuccessInfo(List<BeanBeauty> list);
    }
}
