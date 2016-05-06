package com.yyj.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.endaily.R;
import com.yyj.DataBase.MyDataBase;
import com.yyj.adapter.NewsAdapter;
import com.yyj.bean.News;
import com.yyj.ui.XListView;
import com.yyj.ui.XListViewFooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/3/22.
 */
public class RemoveCollectDialog extends DialogFragment{
    private static RemoveCollectDialog dialog;
    private News.ShowapiResBodyEntity.NewslistEntity news;
    private NewsAdapter adapter;
    private boolean isNoImage;
    private XListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_removecollectdialog,container,false);
       getDialog().requestWindowFeature(STYLE_NO_TITLE);
        TextView textView = (TextView) view.findViewById(R.id.removecollect);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = news.getUrl();
                MyDataBase.getInstance().deleteNews(url);
                List<News.ShowapiResBodyEntity.NewslistEntity> list = MyDataBase.getInstance()
                        .queryall();
                adapter= new NewsAdapter(getActivity(),
                        (ArrayList<News.ShowapiResBodyEntity.NewslistEntity>) list,isNoImage);
                mListView.setAdapter(adapter);
                if (list.size()==0) {
                    XListViewFooter.mHintView.setText("您还未添加任何收藏");
                }
                dialog.dismiss();
            }
        });
        return view;
    }

    public static RemoveCollectDialog getInstance(News.ShowapiResBodyEntity.NewslistEntity news,
                                                  NewsAdapter adapter,XListView xListView,boolean isNoImage) {
        if (dialog==null) {
            dialog = new RemoveCollectDialog();
        }
        dialog.news = news;
        dialog.adapter=adapter;
        dialog.isNoImage = isNoImage;
        dialog.mListView = xListView;
        return  dialog;
    }

    @Override
    public void onResume() {
        getDialog().getWindow().setLayout(350,175);
        super.onResume();
    }
}
