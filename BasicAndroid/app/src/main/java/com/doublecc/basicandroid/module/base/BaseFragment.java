package com.doublecc.basicandroid.module.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public abstract class BaseFragment extends Fragment {

    public abstract int getContentViewId();
    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this,mRootView);
        this.mContext = getActivity();
        return mRootView;
    }
}
