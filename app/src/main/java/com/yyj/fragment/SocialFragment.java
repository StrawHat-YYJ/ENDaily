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

import com.example.administrator.endaily.R;
import com.example.administrator.endaily.SocialJxActivity;
import com.example.administrator.endaily.WebViewActivity;
import com.yyj.ConfigConstant.Api;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class SocialFragment extends Fragment implements View.OnClickListener{
    private ImageView jokeIv;
    private TextView jokeTv;
    private Intent intent= new Intent();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_social,container,false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.social_jokeLayout);
        jokeIv= (ImageView) view.findViewById(R.id.social_jokeIv);
        jokeTv= (TextView) view.findViewById(R.id.social_jokeTv);
        layout.setOnClickListener(this);
        LinearLayout nbaLayout = (LinearLayout) view.findViewById(R.id.social_NBALayout);
        nbaLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.social_jokeLayout:
                intent.setClass(getContext(), SocialJxActivity.class);
                startActivity(intent);
                break;
            case R.id.social_NBALayout:
                intent.setClass(getContext(), WebViewActivity.class);
                intent.putExtra("url", Api.nba);
                intent.putExtra("title","NBA资讯");
                startActivity(intent);
                break;
        }
    }
}
