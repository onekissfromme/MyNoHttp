package com.leke.volleydemo.leke;


import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.leke.volleydemo.LekeApplication;

/**
 * 用SharedPreferences存储
 * 
 * @author zhaotengfei
 * 
 */

public class DataUtils {
	
    public static final String KEY_BALANCE_HOST = "balanceclass.leke.cn";
    
    public static final String KEY_CLASS_HOST = "class.leke.cn";
    
//    public static final String KEY_APPCNSTRONG_HOST = "app.cnstrong.cn";
    
    public static final String KEY_ONLINECLASS_HOST = "onlineclass.leke.cn";
    
    public static final String KEY_TUTOR_HOST = "tutor.leke.cn";
    
    public static final String KEY_HOMEWORK_HOST = "homework.leke.cn";
    
    public static final String KEY_FILELEKE_HOST = "file.leke.cn";
    
    public static final String KEY_GW_HOST = "gw.mo.leke.cn";
    
    public static final String KEY_API_LEKE_HOST = "api.leke.cn";
    
    public static final String KEY_HAS_SHOW_BOTTOMINPUT = "has_show_bottominput";
	
	public static SharedPreferences sharedPreferences = LekeApplication.getInstances()
			.getSharedPreferences(LekeApplication.getInstances().getPackageName(), 0);

	public static void removePreferences(String key) {
		if (key == null) {
			return;
		}

		Editor editor = DataUtils.sharedPreferences.edit();
		editor.remove(key);
		editor.commit();
	}

	public static synchronized void putPreferences(String key, String value) {
		if (key == null || value == null) {
			return;
		}
		Editor editor = DataUtils.sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static void putPreferences(String key, boolean value) {
		Editor editor = DataUtils.sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void putPreferences(String key, int value) {
		Editor editor = DataUtils.sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static void putPreferences(String key, long value) {
		Editor editor = DataUtils.sharedPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public static void putPreferences(String key, float value) {
		Editor editor = DataUtils.sharedPreferences.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	public static boolean getPreferences(String key, boolean defaultValue) {
		try {
			return DataUtils.sharedPreferences.getBoolean(key, defaultValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static int getPreferences(String key, int defValue) {
		try {
			return DataUtils.sharedPreferences.getInt(key, defValue);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static String getPreferences(String key, String defValue) {
		try {
			return DataUtils.sharedPreferences.getString(key, defValue);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static long getPreferences(String key, long defValue) {
		try {
			return DataUtils.sharedPreferences.getLong(key, defValue);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static float getPreferences(String key, float defValue) {
		try {
			return DataUtils.sharedPreferences.getFloat(key, defValue);
		} catch (Exception e) {
			return defValue;
		}
	}
	
	

}
