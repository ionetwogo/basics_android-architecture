package com.doublecc.basicandroid.module.main;

import com.doublecc.basicandroid.bean.BeanTechnology;
import com.doublecc.basicandroid.module.base.BaseDataBridge;
import com.doublecc.basicandroid.module.base.BaseModel;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BasePresenterImpl;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class MainPresenterImpl extends BasePresenterImpl implements BasePresenter.mainPresenter,BaseDataBridge.TechnologyInfo{

    private BaseModel.mainModel mainModel;
    private TechnologyFragment fragment;

    public MainPresenterImpl(TechnologyFragment view) {
        super(view);
        this.fragment = view;
        mainModel = new MainModelImpl();
    }

    @Override
    public void requestData(String url,int number, int page) {
        mainModel.getInfo(url,number,page,this);
    }

    @Override
    public void successRequest(List<BeanTechnology> list) {
        fragment.onSuccessInfo(list);
    }

    @Override
    public void failureRequest(String message) {
        fragment.onFailure(message);
    }
}
