package com.doublecc.basicandroid.module.main;

import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModule;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BasePresenterImpl;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class MainPresenterImpl extends BasePresenterImpl implements BasePresenter.mainPresenter,BaseDataBridge.TechnologyInfo{

    private BaseModule.mainModule mainModule;
    private TechnologyFragment fragment;

    public MainPresenterImpl(TechnologyFragment view) {
        super(view);
        this.fragment = view;
        mainModule = new MainModuleImpl();
    }

    @Override
    public void requestData(int number, int page) {
        mainModule.getInfo(number,page,this);
    }

    @Override
    public void successRequest(List<BeanBeauty> list) {
        fragment.onSuccessInfo(list);
    }

    @Override
    public void failureRequest(String message) {
        fragment.onFailure(message);
    }
}
