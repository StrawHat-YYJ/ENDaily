package com.yyj.dialog;

import android.content.Context;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.MainActivity;
import com.example.administrator.endaily.R;
import com.example.administrator.endaily.SetActivity;
import com.example.administrator.endaily.SocialJxActivity;
import com.example.administrator.endaily.WebViewActivity;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class SettingDialog extends DialogFragment implements View.OnClickListener{
    private TextView settingTv,themeChangeTv;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_settingdialog,
                container,false);
        LinearLayout themeLayout = (LinearLayout) view.findViewById(R.id.settingdialog_themelayout);
        LinearLayout setLayout = (LinearLayout) view.findViewById(R.id.settingdialog_setlayout);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        final DisplayMetrics dm = new DisplayMetrics();
        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.height =dm.heightPixels;
        layoutParams.gravity = Gravity.TOP|Gravity.RIGHT;
        getDialog().getWindow().setAttributes(layoutParams);
        themeLayout.setOnClickListener(this);
        setLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //设置Dialogfragment大小
        getDialog().getWindow().setLayout(350,230);
    }

    public void themeSwap() {
        MainActivity.changeTheme();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingdialog_themelayout:
                themeSwap();
                getDialog().dismiss();
                break;
            case R.id.settingdialog_setlayout:
                Intent intent = new Intent();
                intent.setClass(getActivity(), SetActivity.class);
                startActivity(intent);
                getDialog().dismiss();
                break;
        }
    }
}
