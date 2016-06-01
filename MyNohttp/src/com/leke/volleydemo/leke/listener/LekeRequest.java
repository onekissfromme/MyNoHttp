package com.leke.volleydemo.leke.listener;

/**
 * ProjectName: Fengyun_Information
 * ClassName: LekeRequest
 * User: xfeng
 * <p>
 * Date: 2016-05-23 12:16
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public abstract class LekeRequest {

    /**
     * 定义方法类型的接口
     */
    public interface Method {
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }


    /**
     * 定义返回类型的接口
     */
    public interface ResposeType{
        int StringType = 0 ;
        int JSonType = 1 ;
        int JSonArrayType = 2 ;
    }
}
