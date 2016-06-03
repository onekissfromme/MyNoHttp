package com.leke.volleydemo.nohttpplug;

import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.StringRequest;

/**
 * Created by xuyuqiang on 16/5/30.
 */
public class MyNoHttpRequest extends StringRequest {

    public MyNoHttpRequest(String url) {
        super(url);
    }

    public MyNoHttpRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    /**
     *
     * User: xuyuqiang
     * Data: 16/6/3 14:15
     */
    @Override
    public String getAccept() {
        return "";
    }
}
