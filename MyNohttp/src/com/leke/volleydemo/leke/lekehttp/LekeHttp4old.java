package com.leke.volleydemo.leke.lekehttp;

import android.content.Context;

import com.google.gson.Gson;
import com.leke.volleydemo.leke.listener.LekeRequestMethod;
import com.leke.volleydemo.leke.listener.LekeResponse;
import com.leke.volleydemo.nohttpplug.MyNoHttpRequest;
import com.leke.volleydemo.leke.request.BaseRequest;
import com.leke.volleydemo.nohttpplug.HttpListener;
import com.leke.volleydemo.nohttpplug.LekeRequestServer;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.Response;

import java.util.Map;

/**
 * Created by xuyuqiang on 16/5/30.
 */
public class LekeHttp4old extends BaseLekeHttp implements HttpListener<String>{

    /**
     * 请求成功时的回调
     */
    private LekeResponse.Listener listener ;
    /**
     * 请求失败时的回调
     */
    private LekeResponse.ErrorListener errorListener ;

    /**
     * 请求对象
     */
    private Request<String> mRequest;

    /**
     *
     * 网络请求
     *
     * @param what              用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what 默认-1,不标记
     * @param method            请求类型:POST OR GET  默认POST
     * @param responseType      返回类型:String or JSON  默认:String
     * @param params            请求参数,必填*
     * @param context           context初始化dialog , 默认为null,不启动dialog
     * @param canCancel         是否允许用户取消请求
     */
    public LekeHttp4old(int what ,String url , LekeRequestMethod method , int responseType , Map<String , Object> params , Context context , boolean canCancel , LekeResponse.Listener listener, LekeResponse.ErrorListener errorListener) {
        this.listener = listener;
        this.errorListener = errorListener;
        doPost(what,method == LekeRequestMethod.GET?RequestMethod.GET:RequestMethod.POST,responseType,params,context,canCancel);
    }
    /**
     *
     * 网络请求
     *
     * @param what              用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what 默认-1,不标记
     * @param method            请求类型:POST OR GET  默认POST
     * @param responseType      返回类型:String or JSON  默认:String
     * @param params            请求参数,必填*
     * @param canCancel         是否允许用户取消请求
     */
    public LekeHttp4old(int what , LekeRequestMethod method , int responseType , Map<String , Object> params , boolean canCancel , LekeResponse.Listener listener, LekeResponse.ErrorListener errorListener) {
        this.listener = listener;
        this.errorListener = errorListener;
        doPost(what,method == LekeRequestMethod.GET?RequestMethod.GET:RequestMethod.POST,responseType,params,null,canCancel);
    }

    /**
     *
     * 网络请求
     *
     * @param what              用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what 默认-1,不标记
     * @param params            请求参数,必填*
     * @param canCancel         是否允许用户取消请求
     */
    public LekeHttp4old(int what , Map<String , Object> params , boolean canCancel , LekeResponse.Listener listener, LekeResponse.ErrorListener errorListener) {
        this.listener = listener;
        this.errorListener = errorListener;
        doPost(what,RequestMethod.POST,-1,params,null,canCancel);
    }

    /**
     *
     * 网络请求
     *
     * @param what              用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what 默认-1,不标记
     * @param method            请求类型:POST OR GET  默认POST
     * @param responseType      返回类型:String or JSON  默认:String
     * @param params            请求参数,必填*
     * @param context           context初始化dialog , 默认为null,不启动dialog
     * @param canCancel         是否允许用户取消请求
     */
    private void doPost(int what , RequestMethod method , int responseType , Map<String , Object> params , Context context , boolean canCancel){

        //创建NoHttp请求需要的StringRequest
        mRequest = new MyNoHttpRequest(getHost() , method) ;
        //初始化请求参数
        initParams(params);
        //设置通用请求头
        addHeader("Host" , "tutor.leke.cn");
        LekeRequestServer.getInstance().add(context,what,mRequest,this,canCancel,false);
    }


    /**
     * 初始化URL
     * @return
     */
    private String getHost(){

        return "http://api.leke.cn/api/w/tutor/invoke.htm" ;
    }

    /**
     * 初始化请求参数
     * @param params
     */
    private void initParams(Map<String , Object> params){
        if (mRequest == null || params == null || params.size() <= 0){
            return ;
        }
        params.put("ticket" , "VDBSVlBRPT07Wm5kbVlIYz07ODU4NQ==") ;
        params.put("version" , "1.0.0") ;

        for (String key : params.keySet()){
            Object value = params.get(key) ;
            if (value instanceof BaseRequest){
                mRequest.add(key , new Gson().toJson(value));
            }else{
                mRequest.add(key , (String)value);
            }
        }
    }

    /**
     * 设置网络请求的头信息
     *
     * @param key       请求头的名字
     * @param value     请求头的值
     */
    public void addHeader(String key , String value){
        if (mRequest != null){
            mRequest.addHeader(key , value);
        }
    }

    public void cancelBySign(Object sign){
        LekeRequestServer.getInstance().cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求
     */
    public void cancelAll() {
        LekeRequestServer.getInstance().cancelAll();
    }

    /**
     * 退出app时停止所有请求
     */
    public void stopAll() {
        LekeRequestServer.getInstance().stopAll();
    }

    /**
     * 网络请求成功时的回调方法
     * @param what          网络请求标识码,默认:-1
     * @param response      请求成功的返回内容
     */
    @Override
    public void onSucceed(int what, Response<String> response) {
        if (listener != null){
            listener.onResponse(what,response.get());
        }

        Logger.i(response.get());
    }

    /**
     * 网络请求失败时的返回方法
     * @param what          请求请求标识码
     * @param url           请求的URL
     * @param tag           tag
     * @param message       错误信息
     * @param responseCode  HTTP错误码
     * @param networkMillis 网络请求时长
     */
    @Override
    public void onFailed(int what, String url, Object tag, CharSequence message, int responseCode, long networkMillis) {
        if (errorListener != null){
            errorListener.onErrorResponse(what,message.toString());
        }

        Logger.e(String.valueOf(what));
        Logger.e(url);
        Logger.e(message.toString());
        Logger.e(String.valueOf(responseCode));
        Logger.e(String.valueOf(networkMillis));
    }
}
