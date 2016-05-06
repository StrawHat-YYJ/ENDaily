package com.yyj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.endaily.AboutActivity;
import com.example.administrator.endaily.CollectActivity;
import com.example.administrator.endaily.R;
import com.example.administrator.endaily.SetActivity;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class MoreFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_more,container,false);
        LinearLayout setLayout = (LinearLayout) view.findViewById(R.id.more_setting_layout);
        LinearLayout collectLayout= (LinearLayout) view.findViewById(R.id.more_collect_layout);
        LinearLayout aboutLayout = (LinearLayout) view.findViewById(R.id.more_about_layout);
        aboutLayout.setOnClickListener(this);
        setLayout.setOnClickListener(this);
        collectLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_setting_layout:
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
                break;
            case R.id.more_collect_layout:
                Intent intent1 = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent1);
                break;
            case R.id.more_about_layout:
                Intent intent2 = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
