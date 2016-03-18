package com.example.administrator.endaily;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 草帽儿 on 2016/2/25.
 */
public class BaseApplication extends Application{
    private static BaseApplication application;
    private boolean isNightMode;
    public static List<Activity> activityList = new ArrayList<Activity>();
    private boolean isNoImage;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        setIsNightMode(false);
    }

    public static BaseApplication getApplication() {
        if (application==null) {
            application= new BaseApplication();
        }
        return application;
    }

    public static void setApplication(BaseApplication application) {
        BaseApplication.application = application;
    }

    public boolean isNightMode() {
        return isNightMode;
    }

    public void setIsNightMode(boolean isNightMode) {
        this.isNightMode = isNightMode;
    }

    public static List<Activity> getActivityList() {
        return activityList;
    }

    public static void setActivityList(List<Activity> activityList) {
        BaseApplication.activityList = activityList;
    }

    public boolean isNoImage() {
        return isNoImage;
    }

    public void setIsNoImage(boolean isNoImage) {
        this.isNoImage = isNoImage;
    }
}
