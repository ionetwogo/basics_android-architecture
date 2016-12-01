package com.doublecc.basicandroid.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DoubleCC on 2016/11/30 0030.
 */

public class GankResult<T> {
    public boolean error;
    public @SerializedName("results")
    List<T> datalist;
}
