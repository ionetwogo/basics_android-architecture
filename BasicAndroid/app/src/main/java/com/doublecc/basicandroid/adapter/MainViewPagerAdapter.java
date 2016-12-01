package com.doublecc.basicandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.doublecc.basicandroid.module.main.TechnologyFragment;

/**
 * 主viewpager适配
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mLableList;
    public MainViewPagerAdapter(FragmentManager fm,String[] mLableList) {
        super(fm);
        this.mLableList = mLableList;
    }

    @Override
    public Fragment getItem(int position) {
        return TechnologyFragment.getTechnologyFragment(position);
    }

    @Override
    public int getCount() {
        return mLableList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLableList[position];
    }
}
