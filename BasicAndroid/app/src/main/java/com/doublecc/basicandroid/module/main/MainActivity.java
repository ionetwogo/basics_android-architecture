package com.doublecc.basicandroid.module.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.MainViewPagerAdapter;
import com.doublecc.basicandroid.module.base.BaseActivity;
import com.doublecc.basicandroid.module.base.BaseView;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements BaseView.main{

    @BindView(R.id.rl_menu)
    RelativeLayout mRlMenu;
    @BindView(R.id.img_avatar)
    ImageView mImgAvatar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.tabstrip)
    PagerSlidingTabStrip mTabStrip;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindArray(R.array.technology_lable)
    String[] lableStr;

    private MainViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    private void getData() {
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),lableStr);
        mViewPager.setAdapter(mAdapter);
        mTabStrip.setViewPager(mViewPager);
        initTabsValue();
    }

    @Override
    public void onSuccessInfo() {

    }

    @Override
    public void onFailure() {

    }

    /**
     * mPagerSlidingTabStrip默认值配置
     *
     */
    private void initTabsValue() {
        // 底部游标颜色
        mTabStrip.setIndicatorColor(R.color.colorBrownPrimaryDark);
        // tab的分割线颜色
        mTabStrip.setDividerColor(Color.TRANSPARENT);
        // tab背景
        mTabStrip.setBackgroundColor(ContextCompat.getColor(this,R.color.colorBrownPrimary));
        // tab底线高度
        mTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                1, getResources().getDisplayMetrics()));
        // 游标高度
        mTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, getResources().getDisplayMetrics()));

        // 正常文字颜色
        mTabStrip.setTextColor(Color.WHITE);
    }
}
