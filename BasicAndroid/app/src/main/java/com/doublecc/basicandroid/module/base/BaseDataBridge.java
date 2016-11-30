package com.doublecc.basicandroid.module.base;

import com.doublecc.basicandroid.bean.BeanBeauty;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/30 0030.
 */

public interface BaseDataBridge {
    void failureRequest(String message);
    interface TechnologyInfo extends BaseDataBridge{
        void successRequest(List<BeanBeauty> list);
    }
}
