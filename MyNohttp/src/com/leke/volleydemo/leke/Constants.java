package com.leke.volleydemo.leke;

public interface Constants {

	public final String PACKAGE_NAME = "com.strong.leke";

	public static final String PREF_USERNAME = "pref_user_name";

	public static final String TEACHERROLE = "TeacherRole";

	public static final String HOMEWORK_DTL_ID = "mHomeworkDtlId";

	public static final String NAMEWORK_NAME = "NameworkName";

	public static final String SPANNABLE_STRING = "SpannableString";

	public static final String HOMEWORK_ID = "HomeworkId";

	public static final String BACK_ID = "BackId";

	public static final String HOMEWORK_NAME = "HomeworkName";

	public static final int HAND_UP_LIST_FRAGMENT = 1;

	public static final String MREFLAG = "MREFLAG";

	public static final String IS_SUJECT = "IS_SUJECT";

	public static final String HOMEWORK_DETAIL_LIST = "HomeworkDetailList";
	public static final String HOMEWORK_STUDENT_ANWSER_LIST = "homework_student_anwser_list";

	public static final String MOBILE_GETUSERINFO_REQUEST = "mobile_getUserInfo_request";

	public static final String MOBILE_GETLOGININFO_REQUEST = "mobile_getLoginInfo_request";

	public static final String MOBILE_GETCOURSESINGLEBYDAYFORTEACHER_REQUEST = "mobile_getCourseSingleByDayForTeacher_request";

	public static final String MOBILE_GETCOURSESINGLEBYMONTHFORTEACHER_REQUEST = "mobile_getCourseSingleByMonthForTeacher_request";

	public static final String MOBILE_GETCOURSEFORTEACHER_REQUEST = "mobile_getCourseForTeacher_request";

	public static final String MOBILE_GETCOURSEDETAILFORTEACHER_REQUEST = "mobile_getCourseDetailForTeacher_request";

	public static final String MOBILE_UPDATEUSERINFOFORTEACHER_REQUEST = "mobile_updateUserInfoForTeacher_request";

	public static final String MOBILE_UPDATEPHOTOFORTEACHER_REQUEST = "mobile_updatePhotoForTeacher_request";

	public static final String C_GETHWDTL_REQUEST = "c_getHwDtl_request";

	public static final String C_GETHWPAPERINFO_REQUEST = "c_getHwPaperInfo_request";

	public static final String C_GETHWDTLINFO_REQUEST = "c_getHwDtlInfo_request";

	public static final String M_UPCORRECTRESULT_REQUEST = "m_upCorrectResult_request";
	
	public static final String HANDSHAKE_REQUEST = "handshake_request";

	/* 随堂测试相关 */
	public static final String C_GETPAPERINFO_REQUEST = "c_getPaperInfo_request";

	public static final String MOBILE_HOMEWORK = "device=\"m\"";
	public static final String MOBILE_HOMEWORK_IMAGE = "device=\"img\"";

	public static final int IMAGE_CHANGE = 1;
	public static final int IMAGE_UNCHANGE = 2;

	/** 内容来之PC */
	public static final int COME_FROM_PC = 1;
	/** 内容来之FLASH */
	public static final int COME_FROM_FLASH = 2;
	/** 内容来之APP */
	public static final int COME_FROM_PAD = 3;

	/** 是否是学生 */
	public static final int IS_STUDENT = 0;
	/** 学生ID */
	public static final int STUDENT_ID = 1;
	/** 学生名字 */
	public static final int STUDENT_NAME = 2;
	/** 学生头像url */
	public static final int PHOTO_URL = 3;

	public static final int IsOnline = 0;
	public static final int HandUpStatus = 5;
	public static final int TalkingStatus = 6;

	/** 语音权限 */
	public static final int TALK_AUTOR = 8;

	/** MP3 */
	public static final String MP3 = "mp3";
	/** MP4 */
	public static final String MP4 = "mp4";
	/** FLV */
	public static final String FLV = "flv";

	public static final String PNG = "png";

	public static final String SWF = "swf";

	public static final String JPG = "jpg";

	public static final String PDF = "pdf";
	/** 作业未提交 */
	public static final int HOMEWORK_UNSUBMIT = 0;
	/** 作业已提交 */
	public static final int HOMEWORK_SUBMIT = 1;
	/** 作业以批改 */
	public static final int HOMEWORK_CORRECT = 2;
	
	/** 最大上传宽高 */
	public static final int MAX_WIDTH_HEIGHT = 800;
	
	public static final int SEX_MALE = 1;
	
	public static final int SEX_LADY = 2;
	
	public static final int SEX_SECRET = 3;

	/** 批量奖励类型 */
	public static final int TEACHER_REWARD_MUTUAL = 12303;
	/*
	 * 学生乐币表扬
	 */
	public static final int PRAISE_STUDENT_SCORE=12301;

	/** 请求作业订正信息 **/
	public static final String CORRECT_S = "homework" ;
	public static final String CORRECT_M = "getHwDtlInfo" ;
}
