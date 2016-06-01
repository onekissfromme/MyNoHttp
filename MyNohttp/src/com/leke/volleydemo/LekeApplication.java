package com.leke.volleydemo;

import android.app.Application;

import com.leke.minivolley.RequestQueue;
import com.leke.minivolley.toolbox.Volley;
import com.yolanda.nohttp.NoHttp;

/**
 * ProjectName: LekeVolleyDemo
 * ClassName: LekeApplication
 * User: xfeng
 * <p>
 * Date: 2016-05-25 13:57
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public class LekeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.init(this);
    }
}
