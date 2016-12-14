package com.doublecc.basicandroid.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.TechnologyItemAdapter;
import com.doublecc.basicandroid.bean.BeanTechnology;
import com.doublecc.basicandroid.module.base.BaseFragment;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BaseView;
import com.doublecc.basicandroid.network.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class TechnologyFragment extends BaseFragment implements BaseView.main,OnRefreshListener,OnLoadMoreListener{
    private static final String ARG_POSITION = "argment_position";
    private int position;
    private TechnologyItemAdapter technologyItemAdapter;
    private BasePresenter.mainPresenter mainPresenter;
    private List<BeanTechnology> technologyList;
    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private int pageSize = 20;
    private int page = 1;

    public static TechnologyFragment getTechnologyFragment(int position) {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION,position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
        mainPresenter = new MainPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_technology;
    }

    @Override
    public void getData() {
        switch (position){
            case 0:
                mainPresenter.requestData(Api.TECHNOLOGY_ANDROID,pageSize,page);
                break;
            case 1:
                mainPresenter.requestData(Api.TECHNOLOGY_IOS,pageSize,page);
                break;
            case 2:
                mainPresenter.requestData(Api.TECHNOLOGY_FRONT,pageSize,page);
                break;
        }
    }

    @Override
    public void initView() {
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        technologyList = new ArrayList<BeanTechnology>();
        technologyItemAdapter = new TechnologyItemAdapter(mContext,technologyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(technologyItemAdapter);
    }

    @Override
    public void onSuccessInfo(List<BeanTechnology> list) {
        if (page == 1)technologyList.clear();
        technologyList.addAll(list);
        if (technologyItemAdapter != null){
            technologyItemAdapter.notifyDataSetChanged();
        }
        if (swipeToLoadLayout != null) {
            swipeToLoadLayout.setRefreshing(false);
            swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void onFailure(String message) {
        page --;
        Toast.makeText(mContext,message.toString(),Toast.LENGTH_SHORT).show();
        if (swipeToLoadLayout != null) {
            swipeToLoadLayout.setRefreshing(false);
            swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        page ++;
        getData();
    }
}
