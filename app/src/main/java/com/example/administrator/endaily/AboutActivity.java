package com.example.administrator.endaily;

import android.os.Bundle;

import com.yyj.ui.ChangeTheme;

/**
 * Created by 草帽儿 on 2016/5/6.
 */
public class AboutActivity extends BaseActivity{
    private static ChangeTheme changeTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTheme = new ChangeTheme(this);
        changeTheme.initTheme();
        setContentView(R.layout.activity_about);
    }
}
