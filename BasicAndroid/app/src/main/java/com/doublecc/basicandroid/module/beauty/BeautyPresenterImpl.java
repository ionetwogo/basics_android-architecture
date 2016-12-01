package com.doublecc.basicandroid.module.beauty;

import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModel;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BasePresenterImpl;

import java.util.List;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class BeautyPresenterImpl extends BasePresenterImpl implements BasePresenter.beautyPresenter,BaseDataBridge.BeautyInfo{

    private BaseModel.beautyModel beautyModel;
    private BeautyFragment beautyFragment;

    public BeautyPresenterImpl(BeautyFragment view) {
        super(view);
        this.beautyFragment = view;
        beautyModel = new BeautyModelImpl();
    }

    @Override
    public void requestData(String url, int number, int page) {
        beautyModel.getInfo(url,number,page,this);
    }

    @Override
    public void successRequest(List<BeanBeauty> list) {
        beautyFragment.onSuccessInfo(list);
    }

    @Override
    public void failureRequest(String message) {
        beautyFragment.onFailure(message);
    }
}
