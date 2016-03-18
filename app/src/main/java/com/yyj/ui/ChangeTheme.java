package com.yyj.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.MainActivity;
import com.example.administrator.endaily.R;
import com.example.administrator.endaily.SocialJxActivity;
import com.example.administrator.endaily.WebViewActivity;
import com.yyj.utils.cacheUtil.BaseSharePreferences;

/**
 * Created by 草帽儿 on 2016/3/11.
 */
public class ChangeTheme {
    private Context context;
    private BaseApplication mBaseApp = null;
    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private ViewGroup.LayoutParams mNightViewParam;
    private boolean mIsAddedView;
    private BaseSharePreferences baseSharePreferences;

    public ChangeTheme(Context context){
        this.context= context;
    }

    public void initTheme() {
        if (context instanceof Activity) {
//            mBaseApp =(BaseApplication)(((Activity) context).getApplication());
            mBaseApp= BaseApplication.getApplication();
        }
        baseSharePreferences = BaseSharePreferences.getInstance();
        if (baseSharePreferences.getNightMode()) {
            context.setTheme(R.style.AppTheme_night);
            initNightView();
            mNightView.setBackgroundResource(R.color.night_mask);
        } else {
            context.setTheme(R.style.AppTheme_day);
            mIsAddedView = false;
        }
    }

    public void changeToDay() {
//        mBaseApp.setIsNightMode(false);
        baseSharePreferences.setNightMode(false);
        mNightView.setBackgroundResource(android.R.color.transparent);
    }
    public void changeToNight() {
//        mBaseApp.setIsNightMode(true);
        baseSharePreferences.setNightMode(true);
        initNightView();
        mNightView.setBackgroundResource(R.color.night_mask);
    }
    /**
     * wait a time until the onresume finish
     */
    public void recreateOnResume() {
        if (context!=null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (context instanceof MainActivity) {
                        ((MainActivity) context).recreate();
                    } else if (context instanceof WebViewActivity) {
                        ((WebViewActivity) context).recreate();
                    } else if (context instanceof SocialJxActivity) {
                        ((SocialJxActivity) context).recreate();
                    }
                }
            }, 100);
        }
    }
    private void initNightView() {
        if (mIsAddedView == true)
            return;
        mNightViewParam = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mNightView = new View(context);
        mWindowManager.addView(mNightView, mNightViewParam);
        mIsAddedView = true;
    }

    public void changeTheme() {
        if (baseSharePreferences!=null) {
            boolean isNight =baseSharePreferences.getNightMode();
            if (isNight) {
                changeToDay();
            } else {
                changeToNight();
            }
        }
        recreateOnResume();
    }

    public void clearTheme(){
        if (mIsAddedView) {
            mBaseApp = null;
            mWindowManager.removeViewImmediate(mNightView);
            mWindowManager = null;
            mNightView = null;
        }
    }
}
