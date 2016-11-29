package com.doublecc.basicandroid.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.TechnologyItemAdapter;
import com.doublecc.basicandroid.module.base.BaseFragment;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BaseView;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class TechnologyFragment extends BaseFragment implements BaseView.main{

    private TechnologyItemAdapter technologyItemAdapter;
    private BasePresenter.mainPresenter mainPresenter;


    public static TechnologyFragment getTechnologyFragment() {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        technologyItemAdapter = new TechnologyItemAdapter(mContext);
        mainPresenter = new MainPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void getData() {
        mainPresenter.requestData();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_technology;
    }

    @Override
    public void onSuccessInfo() {

    }

    @Override
    public void onFailure() {

    }
}
