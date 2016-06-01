package com.leke.volleydemo.leke.listener;

/**
 * Created by xfeng on 16/5/31.
 */
public enum LekeRequestMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    PATCH("PATCH");

    private final String value;

    private LekeRequestMethod(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
