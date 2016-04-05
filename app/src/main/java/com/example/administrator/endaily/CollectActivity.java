package com.example.administrator.endaily;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.yyj.DataBase.MyDataBase;
import com.yyj.adapter.NewsAdapter;
import com.yyj.bean.News;
import com.yyj.dialog.ItemDialog;
import com.yyj.dialog.RemoveCollectDialog;
import com.yyj.ui.ChangeTheme;
import com.yyj.ui.XListView;
import com.yyj.ui.XListViewFooter;
import com.yyj.utils.cacheUtil.BaseSharePreferences;
import com.yyj.utils.dateutil.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/3/22.
 */
public class CollectActivity extends BaseActivity implements XListView.IXListViewListener{
    private ChangeTheme changeTheme;
    private XListView mListView;
    private List<News.ShowapiResBodyEntity.NewslistEntity> list;
    private NewsAdapter adapter;
    private boolean isNoImage;
    private Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTheme = new ChangeTheme(this);
        isNoImage = BaseSharePreferences.getInstance().getNoImage();
        changeTheme.initTheme();
        setContentView(R.layout.activity_collect);
        mListView = (XListView) findViewById(R.id.collect_listView);
        mListView.setPullLoadEnable(true);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
        mListView.setXListViewListener(this);
        list = MyDataBase.getInstance().queryall();
        adapter = new NewsAdapter(this, (ArrayList<News.ShowapiResBodyEntity.NewslistEntity>) list,isNoImage);
        if (list.size()==0) {
            XListViewFooter.mHintView.setText("您还未添加任何收藏");
        } else {
            XListViewFooter.mHintView.setText("查看更多");
        }
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final News.ShowapiResBodyEntity.NewslistEntity news = list.get(position - 1);
                String url = news.getUrl();
                intent.setClass(CollectActivity.this, WebViewActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("title", news.getTitle());
                startActivity(intent);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                News.ShowapiResBodyEntity.NewslistEntity news = list.get(position-1);
                RemoveCollectDialog.getInstance(news,adapter,mListView,isNoImage).show(getSupportFragmentManager(), "itemDialog");
                return true;
            }
        });

    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime(DateUtils.getRefreshTime());
    }

    @Override
    protected void onDestroy() {
        changeTheme.clearTheme();
        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        list.clear();
        list = MyDataBase.getInstance().queryall();
        adapter = new NewsAdapter(this, (ArrayList<News.ShowapiResBodyEntity.NewslistEntity>) list,isNoImage);
        mListView.setAdapter(adapter);
        onLoad();
    }

    @Override
    public void onLoadMore() {
        list = MyDataBase.getInstance().queryall();
        if (mListView.getAdapter() != null) {
            adapter.notifyDataSetChanged();
        } else {
            adapter = new NewsAdapter(this, (ArrayList<News.ShowapiResBodyEntity.NewslistEntity>) list,isNoImage);
            mListView.setAdapter(adapter);
        }
        onLoad();
        if (list.size()==0) {
            XListViewFooter.mHintView.setText("您还未添加任何收藏");
        }
    }

}
