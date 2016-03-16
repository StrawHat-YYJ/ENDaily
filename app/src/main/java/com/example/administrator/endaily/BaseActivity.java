package com.example.administrator.endaily;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by 草帽儿 on 2016/3/16.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.getActivityList().add(this);
    }
}
