package com.doublecc.basicandroid.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.TechnologyItemAdapter;
import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.module.base.BaseFragment;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BaseView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class TechnologyFragment extends BaseFragment implements BaseView.main{

    private TechnologyItemAdapter technologyItemAdapter;
    private BasePresenter.mainPresenter mainPresenter;
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    public static TechnologyFragment getTechnologyFragment() {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainPresenter = new MainPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_technology;
    }

    @Override
    public void getData() {
        mainPresenter.requestData(15,1);
    }

    @Override
    public void onSuccessInfo(List<BeanBeauty> list) {
        technologyItemAdapter = new TechnologyItemAdapter(mContext,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(technologyItemAdapter);
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(mContext,message.toString(),Toast.LENGTH_SHORT).show();
    }
}
