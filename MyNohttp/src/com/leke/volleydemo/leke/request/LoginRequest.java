package com.leke.volleydemo.leke.request;

import com.leke.volleydemo.leke.request.BaseRequest;

/**
 * Created by xuyuqiang on 16/5/27.
 */
public class LoginRequest extends BaseRequest {

    public Login p ;
    public Login getLogin(){
        return new Login() ;
    }

    public class Login {
        public String loginName ;
        public String password;
    }
}
