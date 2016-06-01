package com.leke.volleydemo.nohttpplug;

import android.content.Context;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestQueue;
import com.yolanda.nohttp.download.DownloadQueue;

/**
 * Created by xuyuqiang on 16/5/30.
 */
public class LekeRequestServer {

    private static LekeRequestServer instances ;

    /**
     * 请求队列
     */
    private RequestQueue mRequestQueue ;

    /**
     * 下载队列
     */
    private static DownloadQueue mDownloadQueue ;

    private LekeRequestServer(){
        this.mRequestQueue = NoHttp.newRequestQueue() ;
    }

    /**
     * 初始化请求队列
     * @return
     *      LekeRequestServer
     */
    public synchronized static LekeRequestServer getInstance(){
        if (instances == null){
            instances = new LekeRequestServer() ;
        }
        return instances ;
    }

    /**
     * 下载队列
     */
    public static DownloadQueue getDownloadInstance() {
        if (mDownloadQueue == null)
            mDownloadQueue = NoHttp.newDownloadQueue();
        return mDownloadQueue;
    }

    public <T> void add(Context context, int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading){
        if (context == null){
            addRequest(what,request,callback,canCancel,isLoading);
        }else{
            addRequest(context,what,request,callback,canCancel,isLoading);
        }
    }

    /**
     * 添加一个请求到请求队列,自动启动loading...
     *
     * @param context   context用来实例化dialog
     * @param what      用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what
     * @param request   请求对象
     * @param callback  结果回调对象
     * @param canCancel 是否允许用户取消请求
     * @param isLoading 是否显示dialog
     */
    public <T> void addRequest(Context context, int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading) {
        mRequestQueue.add(what, request, new HttpResponseListener<T>(context, request, callback, canCancel, isLoading));
    }

    /**
     * 添加一个请求到请求队列 , 不启动loading...
     *
     * @param what      用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what
     * @param request   请求对象
     * @param callback  结果回调对象
     * @param canCancel 是否允许用户取消请求
     * @param isLoading 是否显示dialog
     */
    public <T> void addRequest(int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading) {
        mRequestQueue.add(what, request, new HttpResponseListener<T>( request, callback, canCancel, isLoading));
    }

    /**
     * 取消这个sign标记的所有请求
     */
    public void cancelBySign(Object sign) {
        mRequestQueue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求
     */
    public void cancelAll() {
        mRequestQueue.cancelAll();
    }

    /**
     * 退出app时停止所有请求
     */
    public void stopAll() {
        mRequestQueue.stop();
    }


}
