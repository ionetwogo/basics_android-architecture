package com.doublecc.basicandroid.module.base;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BaseModule {
    interface mainModule{
        void getInfo(int number, int page, final BaseDataBridge.TechnologyInfo technologyInfo);
    }
}
