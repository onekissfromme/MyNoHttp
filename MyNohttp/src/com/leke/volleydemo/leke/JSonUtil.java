package com.leke.volleydemo.leke;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leke.volleydemo.leke.bean.BaseResponseBean;

/**
 * Created by xuyuqiang on 16/5/31.
 */
public class JSonUtil {

    public static BaseResponseBean getResposeBean(String json , Class clazz , String memberName){
        Object obj = null ;
        Gson gson = new Gson() ;
        JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject() ;
        JsonObject p = jsonObj.getAsJsonObject("p") ;
        JsonObject datas = p.getAsJsonObject("datas").getAsJsonObject(memberName);
        obj = gson.fromJson(datas ,clazz) ;

        BaseResponseBean baseResponseBean = (BaseResponseBean)obj ;
        baseResponseBean.m = jsonObj.get("m").getAsString() ;
        baseResponseBean.success = p.get("success").getAsBoolean() ;
        baseResponseBean.message = p.get("message").getAsString() ;
        baseResponseBean.ticket = p.get("ticket").getAsString() ;
        return baseResponseBean ;
    }
}
