package com.doublecc.basicandroid.module.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.module.base.BaseActivity;
import com.doublecc.basicandroid.module.beauty.BeautyFragment;
import com.doublecc.basicandroid.widget.ResideLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.ll_menu)
    LinearLayout mRlMenu;
    @BindView(R.id.img_avatar)
    CircleImageView mImgAvatar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.img_lableIcon)
    ImageView mImgLableIcon;
    @BindView(R.id.tv_lableTitle)
    TextView mTvLableTitle;
    @BindView(R.id.resideLayout)
    ResideLayout resideLayout;
    @BindView(R.id.mainfragment)
    FrameLayout mFragment;
    @BindView(R.id.tv_technology)
    TextView mTvTechnology;
    @BindView(R.id.tv_beauty)
    TextView mTvBeauty;

    private Fragment currentFragment;
    private MainFragment mainFragment;
    private BeautyFragment beautyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        if(mainFragment == null)mainFragment = new MainFragment();
        switchFragment(mainFragment);
    }

    @OnClick({R.id.img_lableIcon,R.id.tv_technology,R.id.tv_beauty})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.img_lableIcon:
                resideLayout.openPane();
                break;
            case R.id.tv_technology:
                mTvLableTitle.setText("技术");
                resideLayout.closePane();
                if(mainFragment == null)mainFragment = new MainFragment();
                switchFragment(mainFragment);
                break;
            case R.id.tv_beauty:
                mTvLableTitle.setText("福利");
                resideLayout.closePane();
                if (beautyFragment == null)beautyFragment = new BeautyFragment();
                switchFragment(beautyFragment);
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        if (currentFragment == null || !fragment.getClass().getName().equals(currentFragment.getClass().getName())) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainfragment, fragment).commit();
            currentFragment = fragment;
            if (currentFragment instanceof MainFragment){
                ((MainFragment) currentFragment).setPageSelectListener(new MainFragment.pageSelectListener() {
                    @Override
                    public void openSlide() {
                        resideLayout.openSlide();
                    }

                    @Override
                    public void closeSlide() {
                        resideLayout.closeSlide();
                    }
                });
            }
        }
    }

}
