package com.doublecc.basicandroid.module.main;

import android.os.Bundle;
import android.widget.TextView;

import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.bean.BeanTechnology;
import com.doublecc.basicandroid.module.base.BaseActivity;
import com.doublecc.basicandroid.widget.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class TechnologyDetailActivity extends BaseActivity{

    public static final String TECHNOLOGY = "technology_detail";
    private BeanTechnology technology;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_line)
    TextView mTvLine;
    @BindView(R.id.titlebar)
    TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);
        ButterKnife.bind(this);
        technology = (BeanTechnology) getIntent().getSerializableExtra(TECHNOLOGY);

        initView();
    }

    private void initView() {
        mTvTitle.setText(technology.desc);
        mTvAuthor.setText(technology.who);
        mTvTime.setText(technology.createdAt);
        mTvType.setText(technology.type);
        mTvLine.setText(technology.url);

        titleBar.setOnTitleBarClickListener(new TitleBar.titlebarClickListener() {
            @Override
            public void leftClick() {
                // 左边按钮点击操作
            }

            @Override
            public void rightClick() {
                // 右边按钮点击操作
            }
        });
        titleBar.setButtonVisable(true,false);
    }
}
