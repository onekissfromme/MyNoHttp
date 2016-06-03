/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leke.volleydemo.nohttpplug;

import android.content.Context;
import android.content.DialogInterface;

import com.yolanda.nohttp.OnResponseListener;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.Response;


/**
 * Created by xuyuqiang on 16/5/30.
 */
public class HttpResponseListener<T> implements OnResponseListener<T> {

    /**
     * Dialog
     *
     *  由于dialog是由activity才能发起,所以在网络框架中不在封装启动时进度提示
     */
    private WaitDialog mWaitDialog;

    private Request<?> mRequest;

    /**
     * 结果回调
     */
    private HttpListener<T> callback;

    /**
     * 是否显示dialog
     */
    private boolean isLoading;

    /**
     * 网络调用时自动启动loading框,不适用mvp框架
     *
     * @param context      context用来实例化dialog
     * @param request      请求对象
     * @param httpCallback 回调对象
     * @param canCancel    是否允许用户取消请求
     * @param isLoading    是否显示dialog
     */
    public HttpResponseListener(Context context, Request<?> request, HttpListener<T> httpCallback, final boolean canCancel, boolean isLoading) {
        this.mRequest = request;
        if (context != null && isLoading) {
            mWaitDialog = new WaitDialog(context);
            mWaitDialog.setCancelable(canCancel);
            mWaitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mRequest.cancel(canCancel);
                }
            });
        }
        this.callback = httpCallback;
        this.isLoading = isLoading;
    }
    /**
     * 网络调用时不会自动启动loading框,不需要传入当前网页的activity
     *
     * @param request      请求对象
     * @param httpCallback 回调对象
     * @param canCancel    是否允许用户取消请求
     * @param isLoading    是否显示dialog
     */
    public HttpResponseListener( Request<?> request, HttpListener<T> httpCallback, final boolean canCancel, boolean isLoading) {
        this.mRequest = request;
        this.callback = httpCallback;
        this.isLoading = isLoading;

        mRequest.cancel(canCancel);
    }

    /**
     * 开始请求, 这里显示一个dialog
     */
    @Override
    public void onStart(int what) {
        if (isLoading && mWaitDialog != null && !mWaitDialog.isShowing())
            mWaitDialog.show();
    }

    /**
     * 结束请求, 这里关闭dialog
     */
    @Override
    public void onFinish(int what) {
        if (isLoading && mWaitDialog != null && mWaitDialog.isShowing())
            mWaitDialog.dismiss();
    }

    /**
     * 成功回调
     */
    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callback != null)
            callback.onSucceed(what, response);
    }

    /**
     * 失败回调
     */
    @Override
    public void onFailed(int what, String url, Object tag, Exception message, int responseCode, long networkMillis) {
        if (callback != null)
            callback.onFailed(what, url, tag, message.getMessage(), responseCode, networkMillis);
    }

}
