package com.example.administrator.endaily;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.yyj.utils.cacheUtil.BaseSharePreferences;

/**
 * Created by 草帽儿 on 2016/3/16.
 */
public class BaseActivity extends FragmentActivity{
    public BaseSharePreferences sharePreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.getActivityList().add(this);
        sharePreferences = BaseSharePreferences.getInstance();
    }
}
