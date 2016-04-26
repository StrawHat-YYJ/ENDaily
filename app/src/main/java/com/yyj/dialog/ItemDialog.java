package com.yyj.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.endaily.R;
import com.example.administrator.endaily.WebViewActivity;
import com.yyj.DataBase.MyDataBase;
import com.yyj.bean.News;

/**
 * Created by 草帽儿 on 2016/3/22.
 */
public class ItemDialog extends DialogFragment implements View.OnClickListener{
    private static ItemDialog itemDialog;
    private News.ShowapiResBodyEntity.NewslistEntity news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_itemdialog,container,false);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        TextView collectTv = (TextView) view.findViewById(R.id.itemdialog_collect);
        TextView replyTv = (TextView) view.findViewById(R.id.itemdialog_reply);
        replyTv.setOnClickListener(this);
        collectTv.setOnClickListener(this);
        return view;
    }

    public static  ItemDialog getInstance(News.ShowapiResBodyEntity.NewslistEntity news) {
        if (itemDialog==null) {
            itemDialog = new ItemDialog();
        }
       itemDialog.news = news;
        return itemDialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itemdialog_collect:
                String urls = MyDataBase.getInstance().queryUrl();
                String url = news.getUrl();
                if (!urls.contains(url)) {
                    MyDataBase.getInstance().addNews(news);
                } else {
                    Toast.makeText(getActivity(),"您已收藏过该内容。",Toast.LENGTH_SHORT).show();
                }
                itemDialog.dismiss();
                break;
            case R.id.itemdialog_reply:
                String title = news.getTitle();
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("Connected",title);
                startActivity(intent);
                itemDialog.dismiss();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(350,230);
    }
}
