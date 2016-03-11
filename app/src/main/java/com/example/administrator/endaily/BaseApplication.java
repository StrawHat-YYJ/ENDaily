package com.example.administrator.endaily;

import android.app.Application;

/**
 * Created by 草帽儿 on 2016/2/25.
 */
public class BaseApplication extends Application{
    private static BaseApplication application;
    private boolean isNightMode;

    @Override
    public void onCreate() {
        super.onCreate();
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
}
