package com.yyj.utils.cacheUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.administrator.endaily.BaseApplication;

/**
 * Created by 草帽儿 on 2016/3/18.
 */
public class BaseSharePreferences {
    private Context context;
    private static BaseSharePreferences preferences;
    private final String TAG_isNoImage = "isNoImage";

    private final String TAG_isNightMode = "isNightMode";


    public static BaseSharePreferences getInstance() {
        if (preferences==null) {
            preferences = new BaseSharePreferences();
        }
        return preferences;
    }

    public Context getContext() {
        if (context==null) {
            context =BaseApplication.getApplication();
        }
        return context;
    }

    public SharedPreferences getPreferences() {
        return getContext().getSharedPreferences("yyj",Context.MODE_PRIVATE);
    }

    public SharedPreferences.Editor getEditor(){
        return getPreferences().edit();
    }

    public void setNoImage(boolean isNoImage){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TAG_isNoImage,isNoImage);
        editor.commit();
    }

    public boolean getNoImage(){
        return getPreferences().getBoolean(TAG_isNoImage,false);
    }

    public void setNightMode(boolean isNightMode){
        final SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(TAG_isNightMode,isNightMode);
        editor.commit();
    }

    public boolean getNightMode(){
        return getPreferences().getBoolean(TAG_isNightMode,false);
    }
}
