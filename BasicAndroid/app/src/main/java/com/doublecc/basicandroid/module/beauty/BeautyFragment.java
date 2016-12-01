package com.doublecc.basicandroid.module.beauty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

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

public class BeautyFragment extends BaseFragment implements BaseView.beauty{

    @BindView(R.id.rv_beauty)
    RecyclerView mRvBeauty;
    private BasePresenter.beautyPresenter beautyPresenter;
    private BeautyAdapter beautyAdapter;
    private List<BeanBeauty> beautyList;

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
        beautyPresenter.requestData(Api.BEAUTY,15,1);
    }

    @Override
    public void initView() {
        beautyList = new ArrayList<>();
        beautyAdapter = new BeautyAdapter(mContext,beautyList);
        mRvBeauty.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvBeauty.setAdapter(beautyAdapter);
    }

    @Override
    public void onSuccessInfo(List<BeanBeauty> list) {
        beautyList.addAll(list);
        if (beautyAdapter != null){
            beautyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(mContext,message.toString(),Toast.LENGTH_SHORT).show();
    }
}
