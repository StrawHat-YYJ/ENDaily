package com.yyj.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.administrator.endaily.R;

/**
 * Created by 草帽儿 on 2016/3/18.
 */
public class LoadingDialog extends DialogFragment{
    private static LoadingDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_loadingdialog,container,
                false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //设置Dialogfragment大小
        getDialog().getWindow().setLayout(350, 230);
    }

    public static LoadingDialog getInstance() {
        if (dialog==null) {
            dialog = new LoadingDialog();
        }
        return dialog;
    }


}
