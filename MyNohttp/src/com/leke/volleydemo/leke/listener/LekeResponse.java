package com.leke.volleydemo.leke.listener;

/**
 * ProjectName: Fengyun_Information
 * ClassName: LekeResponse
 * User: xfeng
 * <p>
 * Date: 2016-05-23 12:17
 * <p>
 * Version : V 1.0.0
 * throws:
 */
public abstract class LekeResponse<T> {

    /** Callback interface for delivering parsed responses. */
    public interface Listener<T> {
        /** Called when a response is received. */
        public void onResponse(int what, T response);
    }

    /** Callback interface for delivering error responses. */
    public interface ErrorListener {
        /**
         * Callback method that an error has been occurred with the
         * provided error code and optional user-readable message.
         */
        public void onErrorResponse(int what , String error);
    }
}
