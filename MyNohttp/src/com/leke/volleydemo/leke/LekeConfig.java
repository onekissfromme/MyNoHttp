package com.leke.volleydemo.leke;

/**
 * 应用通用信息类
 */
public class LekeConfig {
	
	public final static boolean IS_DEBUG = true;
	
	public final static boolean IS_STORELOG = false;
	
	public final static int SERVER_PORT = 80;
	
	public static String SOKECT_AUDIO_IP = "audio1.leke.cn"; // 登陆SS服务器成功后，同步为SS服务器响应报文中的相应域名以指向相应的音视频服务器


	public static String PDF_IP = null;
	public static String HTTP_SERVER_IP = null;
	public static String HTTP_HOMEWORK_SERVER_IP = null;

	public static String FILE_URL = null;
	public static boolean IS_INTRANET = true;
	public static String BALANCE_SERVER_IP = null;
	public static String SOKECT_SERVER_IP = null;
	public static String GATEWAY_IP = null;
	
	public static String HOMEWORK_NEW = null;
	
	public static String TRANS_IP = null;
	
	public static ApiEnvironment ENVIRONMENT = ApiEnvironment.online;

	static {
		switch (ENVIRONMENT) {
		case test:
			PDF_IP = "http://192.168.20.2";
			HTTP_SERVER_IP = "http://192.168.20.2:9090";
			HTTP_HOMEWORK_SERVER_IP = "http://192.168.20.2:9093";
			FILE_URL = "http://192.168.20.68:18888/";
			BALANCE_SERVER_IP = "192.168.20.156";
			SOKECT_SERVER_IP = "192.168.70.124";
			GATEWAY_IP = "http://192.168.20.39/";
			HOMEWORK_NEW = "http://192.168.20.2";
			TRANS_IP = "http://192.168.20.156/";
			IS_INTRANET = true;
			break;
			
		case pre:
			PDF_IP = "http://192.168.20.71/";
			HTTP_SERVER_IP = "http://192.168.20.2:9090";
			HTTP_HOMEWORK_SERVER_IP = "http://192.168.20.71:9093";
			FILE_URL = "http://192.168.20.68:18888/";
			BALANCE_SERVER_IP = "192.168.20.156";
			SOKECT_SERVER_IP = "192.168.70.124";
			GATEWAY_IP = "";
			HOMEWORK_NEW = "http://192.168.20.2";
			TRANS_IP = "http://192.168.20.156/";
			IS_INTRANET = true;
			break;  

		case online:
			PDF_IP = "http://onlineclass.leke.cn";
			HTTP_SERVER_IP = "http://tutor.leke.cn";
			HTTP_HOMEWORK_SERVER_IP = "http://homework.leke.cn";
			FILE_URL = "http://file.leke.cn";
			BALANCE_SERVER_IP = "balanceclass.leke.cn";
			SOKECT_SERVER_IP = "class.leke.cn";
			GATEWAY_IP = "http://gw.mo.leke.cn/";
			IS_INTRANET = false;
			HOMEWORK_NEW = "http://api.leke.cn";
			TRANS_IP = "http://trans.cnstrong.cn/";
			break;
			
		default:
			break;
		}
	}
	
	public final static String TAG = "LekeTeacher";
 
	public final static String REQUEST_VERSION = "1.0.0"; // 协议版本号
	
	private final static String REQUEST_URL = "/api/w/tutor/invoke.htm";

	public final static String GET_COURSE_lIST = HTTP_SERVER_IP + REQUEST_URL;

	public final static String LOGIN_URL = HTTP_SERVER_IP + "/api/w/tutor/invoke.htm";

	public final static String GET_LOGIN_INFO_URL = HTTP_SERVER_IP + REQUEST_URL;
	public final static String GET_COURSE_COUNT = HTTP_SERVER_IP + REQUEST_URL;
	public final static String GET_TEACHER_ALTER = HTTP_SERVER_IP + REQUEST_URL; // 教师基本信息修改
	public final static String GET_CLASS_LIST = HTTP_SERVER_IP + REQUEST_URL; // 班级列表
	public final static String GET_CLASS_INFO = HTTP_SERVER_IP + REQUEST_URL; // 班级详情
	public final static String PHOTO_URL_UPLOAD = HTTP_SERVER_IP + REQUEST_URL;
	
	/** 文件上传地址 */
	public final static String FILE_UPLOAD = HTTP_SERVER_IP + "/api/w/common/upload/fileUpload.htm";
	
	/** 音频上传地址 */
	public final static String AUDIO_UPLOAD = HTTP_SERVER_IP + "/api/w/common/upload/audio.htm";
	
	public final static String NORMAL_REQUEST_URL = HTTP_SERVER_IP + REQUEST_URL; // 通用request
																					// url
	
	/** 新作业系统接口地址 */
	public final static String HOME_WORK_NEW = HOMEWORK_NEW + "/api/w/invoke.htm";

	public final static String PHOTO_UPLOAD = HTTP_SERVER_IP + "/api/w/common/upload/fileUpload.htm";
	public final static String SOUND_UPLOAD = HTTP_HOMEWORK_SERVER_IP + "/api/w/common/upload/audio.htm";
	
	// homework
	public final static String HOME_WORK = HTTP_HOMEWORK_SERVER_IP + "/api/w/homework/invoke.htm";
	public final static String Up_HOME_WORK = HTTP_HOMEWORK_SERVER_IP + "/api/w/homework/invoke.htm";
	
	/** 代办 */
	public final static String NOTICE_WORK = HOMEWORK_NEW + "/api/w/invoke.htm";

	
	public static final String DOWNLOAD_FILE_PATH = "mnt/sdcard/lekefile/";
	
	public enum ApiEnvironment {
		test,
		pre,
		online
	}

	/** 测试用 **/
	public static String ticket = "" ;
}
