package com.crazyfzw.materialdrawer.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Crazyfzw on 2016/4/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initViews();
        initListeners();
        initData();
    }

    /**
     * 加载布局文件
     */
    public abstract void initContentView();


    /**
     * 初始化布局文件中的控件
     */
    public abstract void initViews();


    /**
     * 初始化控件的监听
     */
    public abstract void initListeners();


    /** 进行数据初始化
     * initData
     */
    public abstract void initData();
}
