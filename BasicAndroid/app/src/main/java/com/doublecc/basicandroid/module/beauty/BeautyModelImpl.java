package com.doublecc.basicandroid.module.beauty;

import com.doublecc.basicandroid.bean.GankResult;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModel;
import com.doublecc.basicandroid.network.NetworlRequest;

import rx.Subscriber;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class BeautyModelImpl implements BaseModel.beautyModel {
    @Override
    public void getInfo(String url, int number, int page, final BaseDataBridge.BeautyInfo beautyInfo) {
        NetworlRequest.executeGetBeauty(url, number, page, new Subscriber<GankResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                beautyInfo.failureRequest(e.getMessage());
            }

            @Override
            public void onNext(GankResult gankResult) {
                beautyInfo.successRequest(gankResult.datalist);
            }
        });
    }
}
