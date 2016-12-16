package com.doublecc.basicandroid.module.beauty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.BeautyAdapter;
import com.doublecc.basicandroid.bean.BeanBeauty;
import com.doublecc.basicandroid.module.base.BaseFragment;
import com.doublecc.basicandroid.module.base.BasePresenter;
import com.doublecc.basicandroid.module.base.BaseView;
import com.doublecc.basicandroid.network.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class BeautyFragment extends BaseFragment implements BaseView.beauty,OnRefreshListener,OnLoadMoreListener{

    @BindView(R.id.swipe_target)
    RecyclerView mRvBeauty;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private BasePresenter.beautyPresenter beautyPresenter;
    private BeautyAdapter beautyAdapter;
    private List<BeanBeauty> beautyList;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private int pageSize = 20;
    private int page = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyPresenter = new BeautyPresenterImpl(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_beauty;
    }

    @Override
    public void getData() {
        beautyPresenter.requestData(Api.BEAUTY,pageSize,page);
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

        beautyList = new ArrayList<>();
        beautyAdapter = new BeautyAdapter(mContext,beautyList);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRvBeauty.setLayoutManager(staggeredGridLayoutManager);
        mRvBeauty.setAdapter(beautyAdapter);
        mRvBeauty.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        });
    }

    @Override
    public void onSuccessInfo(List<BeanBeauty> list) {
        if (page == 1)beautyList.clear();
        beautyList.addAll(list);
        if (beautyAdapter != null){
            beautyAdapter.notifyDataSetChanged();
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
