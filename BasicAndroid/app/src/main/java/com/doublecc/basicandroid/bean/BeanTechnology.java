package com.doublecc.basicandroid.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DoubleCC on 2016/12/1 0001.
 */

public class BeanTechnology implements Serializable{
    public String createdAt;
    public String url;
    public String desc;
    @SerializedName("images")
    public List<String> imgs;
    public String type;
    public String who;
}
