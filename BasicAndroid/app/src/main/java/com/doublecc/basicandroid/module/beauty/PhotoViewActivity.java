package com.doublecc.basicandroid.module.beauty;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.doublecc.basicandroid.R;
import com.doublecc.basicandroid.module.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by DoubleCC on 2016/12/13 0013.
 */

public class PhotoViewActivity extends BaseActivity {

    public static final String PHOTO_URL = "photo_url";
    public static final String TRANSIT_PHOTO = "transit_photo";
    private String url;

    @BindView(R.id.photoview)
    PhotoView photoView;
    @BindView(R.id.btnBack)
    RelativeLayout btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoview);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra(PHOTO_URL);
        ViewCompat.setTransitionName(photoView,TRANSIT_PHOTO);
        
        initView();
    }

    private void initView() {
        Glide.with(this).load(url).into(photoView);
    }

    @OnClick({R.id.btnBack})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBack:
                finish();
                break;
            default:
                break;
        }
    }
}
