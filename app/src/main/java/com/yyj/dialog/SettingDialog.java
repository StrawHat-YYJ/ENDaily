package com.yyj.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.MainActivity;
import com.example.administrator.endaily.R;
import com.example.administrator.endaily.SocialJxActivity;
import com.example.administrator.endaily.WebViewActivity;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class SettingDialog extends DialogFragment{
    private Context context;
    private TextView settingTv,themeSwapTv;
    private boolean isDayModel = true;
    private BaseApplication application = BaseApplication.getApplication();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_settingdialog,
                container,false);
        settingTv= (TextView) view.findViewById(R.id.settingdialog_tv_set);
        themeSwapTv= (TextView) view.findViewById(R.id.settingdialog_tv_about);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        final DisplayMetrics dm = new DisplayMetrics();
        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.height =dm.heightPixels;
        layoutParams.gravity = Gravity.TOP|Gravity.RIGHT;
        getDialog().getWindow().setAttributes(layoutParams);
        themeSwapTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeSwap();
            }
        });
        return view;
    }

    public void themeSwap() {
        MainActivity mainActivity = new MainActivity();
        WebViewActivity webViewActivity = new WebViewActivity();
        SocialJxActivity socialJxActivity = new SocialJxActivity();
        mainActivity.changeTheme();
        webViewActivity.changeTheme();
        socialJxActivity.changeTheme();
    }
}
