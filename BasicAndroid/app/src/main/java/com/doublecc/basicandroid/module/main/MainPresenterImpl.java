package com.doublecc.basicandroid.module.main;

import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BasePresenterImpl;
import com.doublecc.basicandroid.module.base.BaseView;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class MainPresenterImpl extends BasePresenterImpl implements BasePresenter.mainPresenter{

    public MainPresenterImpl(BaseView view) {
        super(view);
    }

    @Override
    public void requestData() {

    }
}
