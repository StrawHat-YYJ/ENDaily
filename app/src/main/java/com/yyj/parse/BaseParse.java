package com.yyj.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yyj.bean.News;

import java.lang.reflect.Type;

/**
 * Created by 草帽儿 on 2016/2/18.
 */
public class BaseParse {
    public static Object parse(String json,Object obj){
        Gson gson = new Gson();
//        Class<News> newsClass = News.class;
//        Type type = new TypeToken<T>(){}.getType();
        Object o = gson.fromJson(json, obj.getClass());
        return o;
    }

    public static <T> T parse1(String json,T t){
        Gson gson = new Gson();
        T o  = (T) gson.fromJson(json,t.getClass());
        return o;
    }
}
