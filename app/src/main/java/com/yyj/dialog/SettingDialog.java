package com.yyj.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.endaily.R;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class SettingDialog extends DialogFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_settingdialog,
                container,false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        final DisplayMetrics dm = new DisplayMetrics();
        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.height =dm.heightPixels;
        layoutParams.gravity = Gravity.TOP|Gravity.RIGHT;
        getDialog().getWindow().setAttributes(layoutParams);
        return view;
    }
}
