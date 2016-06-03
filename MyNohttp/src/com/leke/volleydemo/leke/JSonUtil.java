package com.leke.volleydemo.leke;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leke.volleydemo.leke.bean.BaseResponseBean;

/**
 * Created by xuyuqiang on 16/5/31.
 */
public class JSonUtil {

    /**
     * Json转换方法
     * User: xuyuqiang
     * Data: 16/6/3 16:31
     *
     * @param json          需要转换的JSon字符串
     * @param clazz         需要转换的实体bean,此类需要继承BaseResponseBean
     * @param memberName    需要转换实体bean的:memeberName  必填,否则无法正确解析
     * @return
     *      返回BaseResponseBean 子类
     */
    public static BaseResponseBean getResposeBean(String json , Class clazz , String memberName){

        if (TextUtils.isEmpty(json) || TextUtils.isEmpty(memberName)){
            return null ;
        }

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
