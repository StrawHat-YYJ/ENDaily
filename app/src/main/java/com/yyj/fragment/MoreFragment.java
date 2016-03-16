package com.yyj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ImageView moreSetIv = (ImageView) view.findViewById(R.id.more_setting_iv);
        TextView moreSetTv = (TextView) view.findViewById(R.id.more_setting_tv);
        moreSetIv.setOnClickListener(this);
        moreSetTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_setting_iv:
            case R.id.more_setting_tv:
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
        }
    }
}
