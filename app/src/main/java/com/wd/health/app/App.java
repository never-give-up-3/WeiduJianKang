package com.wd.health.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:00
 */
public class App extends Application {
    //全局上下文
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Fresco.initialize(this);
    }

    public static App getAppContext() {
        return sContext;
    }

}
