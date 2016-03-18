package com.example.administrator.endaily;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yyj.ui.ChangeTheme;
import com.yyj.utils.netUtil.HttpVolley;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by 草帽儿 on 2016/3/15.
 */
public class SetActivity extends BaseActivity implements View.OnClickListener{
    private static ChangeTheme changeTheme;
    private boolean isNoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeTheme = new ChangeTheme(this);
        changeTheme.initTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setactivity);
        initView();
    }

    private void initView() {
        TextView clearCacheTv = (TextView) findViewById(R.id.setAty_clearCache);
        LinearLayout layout = (LinearLayout) findViewById(R.id.setAty_clearCacheLayout);
        layout.setOnClickListener(this);
        clearCacheTv.setOnClickListener(this);
        LinearLayout noImage = (LinearLayout) findViewById(R.id.setAty_noImageLayout);
        noImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setAty_clearCache:
            case R.id.setAty_clearCacheLayout:
                File mfile=new File(HttpVolley.downloadDir);
                try{
                    File[] files =mfile.listFiles();
                    for (File file:files) {
                        file.delete();
                    }
                    mfile.delete();
                    Toast.makeText(this,"您已成功清除缓存。",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this,"当前缓存已被清空。",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.setAty_noImageLayout:
                isNoImage=sharePreferences.getNoImage();
                //开启无图模式，只针对首页新闻
                if (isNoImage == false) {
//                    BaseApplication.getApplication().setIsNoImage(true);
                    sharePreferences.setNoImage(true);
                    Toast.makeText(this, "开启无图浏览模式。", Toast.LENGTH_SHORT).show();
                } else {
//                    BaseApplication.getApplication().setIsNoImage(false);
                    sharePreferences.setNoImage(false);
                    Toast.makeText(this,"关闭无图浏览模式。",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
