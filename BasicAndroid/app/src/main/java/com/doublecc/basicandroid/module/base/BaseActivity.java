package com.doublecc.basicandroid.module.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
