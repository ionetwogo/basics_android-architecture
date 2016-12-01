package com.doublecc.basicandroid.module.base;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public interface BaseModel {
    interface mainModel {
        void getInfo(String url,int number, int page, final BaseDataBridge.TechnologyInfo technologyInfo);
    }
    interface beautyModel{
        void getInfo(String url,int number, int page, final BaseDataBridge.BeautyInfo beautyInfo);
    }
}
