package com.doublecc.basicandroid.module.main;

import com.doublecc.basicandroid.bean.GankResult;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModule;
import com.doublecc.basicandroid.network.Api;
import com.doublecc.basicandroid.network.NetworlRequest;

import rx.Subscriber;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class MainModuleImpl implements BaseModule.mainModule{

    @Override
    public void getInfo(int number, int page, final BaseDataBridge.TechnologyInfo technologyInfo) {
        NetworlRequest.executeGetRequest(Api.BEAUTY, number,page, new Subscriber<GankResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                technologyInfo.failureRequest(e.getMessage());
            }

            @Override
            public void onNext(GankResult gankResult) {
                technologyInfo.successRequest(gankResult.beauties);
            }
        });
    }
}
