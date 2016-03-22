package com.yyj.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.administrator.endaily.BaseApplication;
import com.yyj.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/3/22.
 */
public class MyDataBase {
    private static SQLiteDatabase database;
    private static MyDataBase myDataBase;


    public static MyDataBase getInstance() {
        if (database==null) {
            database = MyDataBaseHelper.getInstance().getWritableDatabase();
        }
        if (myDataBase==null) {
            myDataBase = new MyDataBase();
        }
        return myDataBase;
    }

    public long addNews(News.ShowapiResBodyEntity.NewslistEntity news) {
        ContentValues cv = new ContentValues();
        cv.put("url",news.getUrl());
        cv.put("des",news.getDescription());
        cv.put("cTime",news.getCtime());
        cv.put("picUrl",news.getPicUrl());
        cv.put("title", news.getTitle());
        long insert =database.insert("news", null, cv);
//        database.close();
        if (insert != -1) {
            Toast.makeText(BaseApplication.getApplication(), "已添加到收藏。", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BaseApplication.getApplication(), "收藏失败。", Toast.LENGTH_SHORT).show();
        }
        return insert;
    }

    public int deleteNews(String url) {
        int delete = database
                .delete("news", "url=?", new String[]{url});
//        database.close();
        if (delete != -1) {
            Toast.makeText(BaseApplication.getApplication(), "删除成功。", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BaseApplication.getApplication(), "删除失败。", Toast.LENGTH_SHORT).show();
        }
        return delete;
    }

    public List<News.ShowapiResBodyEntity.NewslistEntity> queryall() {
        List<News.ShowapiResBodyEntity.NewslistEntity> list =
                new ArrayList<News.ShowapiResBodyEntity.NewslistEntity>();
        Cursor cursor = database.query("news", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String url = cursor.getString(cursor.getColumnIndex("url"));
            String des = cursor.getString(cursor.getColumnIndex("des"));
            String cTime = cursor.getString(cursor.getColumnIndex("cTime"));
            String picUrl = cursor.getString(cursor.getColumnIndex("picUrl"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            News.ShowapiResBodyEntity.NewslistEntity news =
                    new News.ShowapiResBodyEntity.NewslistEntity();
            news.setUrl(url);
            news.setDescription(des);
            news.setCtime(cTime);
            news.setPicUrl(picUrl);
            news.setTitle(title);
            list.add(news);
        }
        return list;
    }

    public String queryUrl(){
        StringBuilder builder = new StringBuilder();
        Cursor cursor = database.query("news", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String url = cursor.getString(cursor.getColumnIndex("url"));
           builder.append(url);
        }
        return builder.toString();
    }

}
