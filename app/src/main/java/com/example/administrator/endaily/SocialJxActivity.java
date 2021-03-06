package com.example.administrator.endaily;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;

import com.yyj.ConfigConstant.Api;
import com.yyj.adapter.JokesAdapter;
import com.yyj.bean.Jokes;
import com.yyj.dialog.LoadingDialog;
import com.yyj.parse.BaseParse;
import com.yyj.ui.ChangeTheme;
import com.yyj.ui.XListView;
import com.yyj.utils.dateutil.DateUtils;
import com.yyj.utils.netUtil.HttpVolley;

import java.util.ArrayList;

/**
 * Created by 草帽儿 on 2016/2/22.
 * 社交——精选
 */
public class SocialJxActivity extends BaseActivity implements XListView.IXListViewListener{
    private XListView mxListView;
    private ArrayList<Jokes.ShowapiResBodyEntity.ContentlistEntity> list=
            new ArrayList<Jokes.ShowapiResBodyEntity.ContentlistEntity>();
    private JokesAdapter jokesAdapter;
    //请求页数
    private int i=1;
    private static ChangeTheme changeTheme;
    private LoadingDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeTheme= new ChangeTheme(this);
        changeTheme.initTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_social_joke);
        dialog = LoadingDialog.getInstance();
        mxListView= (XListView) findViewById(R.id.social_joke_xlistview);
        mxListView.setPullLoadEnable(true);
//		mxListView.setPullLoadEnable(false);
//		mxListView.setPullRefreshEnable(false);
        mxListView.setXListViewListener(this);
//        mxListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            }
//        });
        HttpVolley.getData(this, Api.url_jokes, Api.numsPerPage, "" + i, handler);
    }
    private void onLoad() {
        mxListView.stopRefresh();
        mxListView.stopLoadMore();
        mxListView.setRefreshTime(DateUtils.getRefreshTime());
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                i = 1;
                list.clear();
                HttpVolley.getData(SocialJxActivity.this, Api.url_jokes, Api.numsPerPage, "" + i, handler);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HttpVolley.getData(SocialJxActivity.this, Api.url_jokes, Api.numsPerPage, "" + (++i), handler);
                onLoad();
            }
        }, 2000);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           String jokesString=(String)msg.obj;
            if (jokesString!=null) {
                Jokes jokes= (Jokes)BaseParse.parse(jokesString,new Jokes());
                ArrayList<Jokes.ShowapiResBodyEntity.ContentlistEntity> jokesList=
                        jokes.getShowapi_res_body().getContentlist();
                if (jokesList!=null) {
                    list.addAll(jokesList);
                    if (mxListView.getAdapter()!=null) {
                        jokesAdapter.notifyDataSetChanged();
                    }else {
                        jokesAdapter=new JokesAdapter(SocialJxActivity.this,list);
                        mxListView.setAdapter(jokesAdapter);
                        dialog.dismiss();
                    }
                }
            }

        }
    };

    @Override
    protected void onDestroy() {
        changeTheme.clearTheme();
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (jokesAdapter==null) {
            dialog.show(getSupportFragmentManager(),"");
        }
    }
}
