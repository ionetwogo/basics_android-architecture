package com.doublecc.basicandroid.module.main;

import com.doublecc.basicandroid.bean.GankResult;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModel;
import com.doublecc.basicandroid.network.NetworlRequest;

import rx.Subscriber;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class MainModelImpl implements BaseModel.mainModel {

    @Override
    public void getInfo(String url,int number, int page, final BaseDataBridge.TechnologyInfo technologyInfo) {
        NetworlRequest.executeGetTechnolgy(url, number,page, new Subscriber<GankResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                technologyInfo.failureRequest(e.getMessage());
            }

            @Override
            public void onNext(GankResult gankResult) {
                technologyInfo.successRequest(gankResult.datalist);
            }
        });
    }
}
