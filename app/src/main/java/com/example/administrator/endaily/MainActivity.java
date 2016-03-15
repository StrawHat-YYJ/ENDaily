package com.example.administrator.endaily;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yyj.adapter.MyFragmentPagerAdapter;
import com.yyj.dialog.SettingDialog;
import com.yyj.fragment.MoreFragment;
import com.yyj.fragment.NewsFragment;
import com.yyj.fragment.SocialFragment;
import com.yyj.ui.ChangeTheme;
import com.yyj.utils.netUtil.HttpVolley;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ViewPager viewPager;
    public TabLayout tabLayout;
    public ImageView moreiv;
    public ArrayList<Fragment> viewContainer=new ArrayList<Fragment>();
    public ArrayList<String> titleContainer=new ArrayList<String>();
    public NewsFragment newsFragment;
    public SocialFragment socialFragment;
    public MoreFragment moreFragment;
    private long exitTime;

    private static ChangeTheme changeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeTheme = new ChangeTheme(this);
        changeTheme.initTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        linkViewPagerAndTabLayout();
    }
    public void initView(){
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        moreiv= (ImageView) findViewById(R.id.moreIv);
        moreiv.setOnClickListener(this);
        newsFragment = new NewsFragment();
        socialFragment = new SocialFragment();
        moreFragment = new MoreFragment();
    }
    public void initData(){
        //viewpager添加视图
        viewContainer.add(newsFragment);
        viewContainer.add(socialFragment);
        viewContainer.add(moreFragment);
        //tablayout添加标签
        titleContainer.add("新闻");
        titleContainer.add("社区");
        titleContainer.add("更多");
    }
    /**
     * @author yyj
     * create at 2016/1/23 15:13
     * 关联ViewPager和Tablayout
     * @param
     * @return
     */

    public void linkViewPagerAndTabLayout(){
        MyFragmentPagerAdapter fragmentPagerAdapter= new
                MyFragmentPagerAdapter(getSupportFragmentManager(),
                viewContainer,titleContainer);
        viewPager.setAdapter(fragmentPagerAdapter);
        //设置模式为默认模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(Color.rgb(181, 181, 181),
                Color.rgb(255, 255, 255));
        tabLayout.setSelectedTabIndicatorHeight(3);
        tabLayout.setSelectedTabIndicatorColor(Color.YELLOW);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moreIv:
                showSettingDialogFragment(MainActivity.this);
                break;
            default:
                break;
        }
    }
    public void showSettingDialogFragment(Context context){
        SettingDialog settingDialog= new SettingDialog();
        settingDialog.show(getSupportFragmentManager(), "settingDialog");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {//如果是后退键
            long currentTime = new Date().getTime();
            if (currentTime-exitTime>2000) {//第一次按下时判条件肯定成立，再次按下时exitTime已经赋值
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime=currentTime;
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        changeTheme.clearTheme();
        super.onDestroy();
//        File mfile=new File(HttpVolley.downloadDir);
//        File[] files =mfile.listFiles();
//        for (File file:files) {
//            file.delete();
//        }
//        mfile.delete();
    }

    public static void changeTheme(){
        changeTheme.changeTheme();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
