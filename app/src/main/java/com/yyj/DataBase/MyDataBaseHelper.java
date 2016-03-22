package com.yyj.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.endaily.BaseApplication;

/**
 * Created by 草帽儿 on 2016/3/22.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper{
    private static Context context= BaseApplication.getApplication();
    private static MyDataBaseHelper dataBaseHelper;
    private static final int VERSION = 1;
    private static final String SWORD="SWORD";

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MyDataBaseHelper(Context context,String name){
        this(context, name, VERSION);
    }
    public MyDataBaseHelper(Context context,String name,int version){
        this(context, name,null,version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库sql语句
        String sql = "create table news(url varchar(20),des varchar(20),cTime varchar(20)" +
                ",picUrl varchar(20),title varchar(20))";
        //执行创建数据库操作
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static MyDataBaseHelper getInstance() {
        if (dataBaseHelper==null) {
            dataBaseHelper = new MyDataBaseHelper(context,"news");
        }
        return dataBaseHelper;
    }
}
