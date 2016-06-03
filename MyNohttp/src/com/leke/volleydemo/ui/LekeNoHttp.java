package com.leke.volleydemo.ui;

import android.content.Context;

import com.leke.volleydemo.leke.listener.LekeResponse;
import com.yolanda.nohttp.RequestMethod;

import java.net.URL;
import java.util.Map;

/**
 *
 * 项目和网络的中间连接类,主要作用就是:根据URL来进行ip替换和URL的重新组装
 *
 * 此类不封装到LekeHttp中,直接复制到项目中
 *
 * User: xuyuqiang
 * Data: 16/6/3 15:31
 */

public class LekeNoHttp {


    /**
     *
     * User: xuyuqiang
     * Data: 16/6/3 15:38
     * @param url
     * @param what
     * @param method
     * @param responseType
     * @param params
     * @param context
     * @param canCancel
     * @param listener
     * @param errorListener
     * @param _s
     * @param _m
     */
    public LekeNoHttp(String url , int what , RequestMethod method , int responseType , Map<String , Object> params , Context context , boolean canCancel , LekeResponse.Listener listener, LekeResponse.ErrorListener errorListener , String _s , String _m) {


    }



    private String changeHost(String url){
        String host = getHost(url) ;
        String requestIp = "" ;  //此处直接调用项目中的IpTableCache.getIpByDomain(host); 进行转换
        return requestIp ;
    }

    /**
     *
     * User: xuyuqiang
     * Data: 16/6/3 15:50
     * @param host    原始的URL地址
     * @return
     *
     *      重新编译后的URL地址
     */
    private String getHost(String host){
        try{
            URL url = new URL(host) ;
            return url.getHost() ;
        }catch (Exception e){

        }
        return "" ;
    }
}
