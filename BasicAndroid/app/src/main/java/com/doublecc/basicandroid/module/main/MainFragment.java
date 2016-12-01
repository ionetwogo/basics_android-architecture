package com.doublecc.basicandroid.module.main;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.astuetz.PagerSlidingTabStrip;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.adapter.MainViewPagerAdapter;
import com.doublecc.basicandroid.module.base.BaseFragment;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.tabstrip)
    PagerSlidingTabStrip mTabStrip;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindArray(R.array.technology_lable)
    String[] lableStr;
    private MainViewPagerAdapter mAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_main;
    }

    @Override
    public void getData() {
        mViewPager.setOffscreenPageLimit(lableStr.length);
        mAdapter = new MainViewPagerAdapter(getChildFragmentManager(),lableStr);
        mViewPager.setAdapter(mAdapter);
        mTabStrip.setViewPager(mViewPager);
        mTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    pageSelectListener.openSlide();
                }else{
                    pageSelectListener.closeSlide();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initTabsValue();
    }

    @Override
    public void initView() {

    }
    private pageSelectListener pageSelectListener;
    public interface pageSelectListener{
        void openSlide();
        void closeSlide();
    }

    public void setPageSelectListener(pageSelectListener pageSelectListener){
        this.pageSelectListener = pageSelectListener;
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
        mTabStrip.setBackgroundColor(ContextCompat.getColor(mContext,R.color.colorBrownPrimary));
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
