package com.example.administrator.endaily;

import android.app.Application;

/**
 * Created by 草帽儿 on 2016/2/25.
 */
public class BaseApplication extends Application{
    private static BaseApplication application;

    public static BaseApplication getApplication() {
        return application;
    }

    public static void setApplication(BaseApplication application) {
        BaseApplication.application = application;
    }
}
