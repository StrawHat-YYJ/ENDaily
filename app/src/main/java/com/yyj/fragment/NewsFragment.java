package com.yyj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.administrator.endaily.BaseApplication;
import com.example.administrator.endaily.R;
import com.example.administrator.endaily.WebViewActivity;
import com.yyj.ConfigConstant.Api;
import com.yyj.adapter.NewsAdapter;
import com.yyj.bean.News;
import com.yyj.dialog.ItemDialog;
import com.yyj.dialog.LoadingDialog;
import com.yyj.parse.BaseParse;
import com.yyj.ui.XListView;
import com.yyj.utils.cacheUtil.BaseSharePreferences;
import com.yyj.utils.dateutil.DateUtils;
import com.yyj.utils.netUtil.HttpVolley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/1/23.
 */
public class NewsFragment extends Fragment implements XListView.IXListViewListener{
    private XListView mListView;
    private NewsAdapter newsAdapter;
    private Intent intent=new Intent();
    private LoadingDialog dialog;
    private ArrayList<News.ShowapiResBodyEntity.NewslistEntity> list=new
            ArrayList<News.ShowapiResBodyEntity.NewslistEntity>();
    private int i=1;
    private boolean isNoImage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_news,container,false);
        dialog = LoadingDialog.getInstance();
        mListView = (XListView)view.findViewById(R.id.xlistview);
        mListView.setPullLoadEnable(true);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
        mListView.setXListViewListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final News.ShowapiResBodyEntity.NewslistEntity news = list.get(position - 1);
                String url = news.getUrl();
                intent.setClass(getContext(), WebViewActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("title", news.getTitle());
                startActivity(intent);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                News.ShowapiResBodyEntity.NewslistEntity news = list.get(position-1);
                ItemDialog.getInstance(news).show(getFragmentManager(),"itemDialog");
                return true;
            }
        });
        HttpVolley.getData(getActivity(), Api.url_news, Api.numsPerPage, "" + i, handler);
        return view;
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime(DateUtils.getRefreshTime());
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                i=1;
                list.clear();
                HttpVolley.getData(getActivity(), Api.url_news, Api.numsPerPage, "" + i, handler);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HttpVolley.getData(getActivity(), Api.url_news, Api.numsPerPage, "" + (++i), handler);
                onLoad();
            }
        }, 2000);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String newsString = (String) msg.obj;
            if (newsString!=null) {
                News news= (News) BaseParse.parse(newsString,new News());
                ArrayList<News.ShowapiResBodyEntity.NewslistEntity> newslist;
                newslist=news.getShowapi_res_body().getNewslist();
                if (newslist!=null) {
                    list.addAll(newslist);
                    if (mListView.getAdapter()!=null){
                        newsAdapter.notifyDataSetChanged();
                    }else {
                        isNoImage = BaseSharePreferences.getInstance().getNoImage();
                        newsAdapter= new NewsAdapter(getActivity(),list,isNoImage);
                        mListView.setAdapter(newsAdapter);
                        dialog.dismiss();
                    }
                }

            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        isNoImage =BaseSharePreferences.getInstance().getNoImage();
        //网络请求异步，adapter可能为空。
        if (newsAdapter != null) {
            newsAdapter.setIsNoImage(isNoImage);
            newsAdapter.notifyDataSetChanged();
        } else {
            dialog.show(getFragmentManager(),"loadingDialog");
        }
    }
}
