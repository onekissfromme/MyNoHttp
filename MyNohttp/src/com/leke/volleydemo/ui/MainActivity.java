package com.leke.volleydemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leke.volleydemo.R;
import com.leke.volleydemo.leke.Constants;
import com.leke.volleydemo.leke.LekeConfig;
import com.leke.volleydemo.leke.bean.User;
import com.leke.volleydemo.leke.lekehttp.LekeHttp;
import com.leke.volleydemo.leke.lekehttp.LekeHttp4old;
import com.leke.volleydemo.leke.listener.LekeResponse;
import com.leke.volleydemo.leke.request.LoginRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener{

	Button loginButton ;
	Button updataButton ;
	Button getHwDtlInfoButton ;
	EditText textView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton = (Button) findViewById(R.id.login);
		updataButton = (Button) findViewById(R.id.updata);
		getHwDtlInfoButton = (Button)findViewById(R.id.getHwDtlInfo) ;
		textView = (EditText) findViewById(R.id.getHwDtlInfoTv);
		loginButton.setOnClickListener(this);
		updataButton.setOnClickListener(this);
		getHwDtlInfoButton.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.login:
				login() ;
				break;
			case R.id.updata:

				break;
			case R.id.getHwDtlInfo:
				getHwDtlInfo();
				break;
			default:
				break;
		}

	}

	/**
	 * 获取作业订正信息
	 */
	private void getHwDtlInfo(){
		Map<String , Object> params = new HashMap<>() ;
		params.put("homeworkDtlId","11953906148") ;
		LekeHttp lekeHttp = new LekeHttp(-1, params, false, new LekeResponse.Listener<String>() {
			@Override
			public void onResponse(int what, String response) {
				Log.i("TestNohttp" , response);
			}
		}, new LekeResponse.ErrorListener() {
			@Override
			public void onErrorResponse(int what, String error) {
				textView.setText(error);
				Log.i("TEST" , error) ;
			}
		} , Constants.CORRECT_S , Constants.CORRECT_M) ;


	}

	/**
	 * 登陆
	 */
	private void login(){
		LoginRequest br = new LoginRequest() ;
		br.direct = 0 ;
		br.m = Constants.MOBILE_GETLOGININFO_REQUEST ;
		LoginRequest.Login login = br.getLogin() ;
		login.loginName = "port_t1" ;
		login.password = "1234567" ;
		br.p = login ;
		Map<String , Object> params = new HashMap<>() ;
		params.put("data" , br) ;

		LekeHttp4old lekeHttp = new LekeHttp4old(-1,params,false ,new LekeResponse.Listener<String>(){
			@Override
			public void onResponse(int what, String response) {
				User user = User.getUser(response) ;
				if (user !=  null){
					LekeConfig.ticket = user.ticket ;
				}
				Log.i("TestNohttp" , response);
			}
		}, new LekeResponse.ErrorListener(){
			@Override
			public void onErrorResponse(int what, String error) {

			}
		}) ;
	}
}
