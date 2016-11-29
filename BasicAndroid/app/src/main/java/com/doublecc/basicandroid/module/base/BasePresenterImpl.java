package com.doublecc.basicandroid.module.base;

/**
 * Created by DoubleCC on 2016/11/29 0029.
 */

public class BasePresenterImpl<T> {
    public T view;
    public BasePresenterImpl(){}
    public BasePresenterImpl(T view){
        this.view = view;
    }
}
