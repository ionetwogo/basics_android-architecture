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

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.rl_menu)
    RelativeLayout mRlMenu;
    @BindView(R.id.img_avatar)
    CircleImageView mImgAvatar;
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
    @BindView(R.id.img_lableIcon)
    ImageView mImgLableIcon;
    @BindView(R.id.tv_lableTitle)
    TextView mTvLableTitle;

    private MainViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),lableStr);
        mViewPager.setAdapter(mAdapter);
        mTabStrip.setViewPager(mViewPager);
        mTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvLableTitle.setText(lableStr[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initTabsValue();
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
