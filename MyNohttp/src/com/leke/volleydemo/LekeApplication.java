package com.leke.volleydemo;

import android.app.Application;

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

    private static LekeApplication instances ;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this ;
        NoHttp.init(this);
    }

    public static LekeApplication getInstances(){
        return instances ;
    }
}
