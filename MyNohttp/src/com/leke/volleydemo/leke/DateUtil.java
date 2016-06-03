package com.leke.volleydemo.leke;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 取得当月天数
	 * */
	public static int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的天数
	 * */
	public static int getMonthLastDay(Calendar calendar) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		a.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到每月第一天是星期几
	 * */
	public static int getCalendarStartDate(Calendar month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month.get(Calendar.MONTH));
		calendar.set(Calendar.YEAR, month.get(Calendar.YEAR));
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 *
	 * 描述:对比2个时间是否是同一天
	 *
	 * @author louwj
	 * @created 2014-12-9 下午6:52:44
	 * @param csList
	 * @return
	 * @return boolean
	 */
	public static boolean checkDate(Date selectDate, Date date2) {
		if (selectDate == null || date2 == null) {
			return false;
		}
		Calendar selectCalendar = Calendar.getInstance();
		selectCalendar.setTime(selectDate);
		Calendar severCalendar = Calendar.getInstance();
		severCalendar.setTime(date2);
		return selectCalendar.get(Calendar.YEAR) == severCalendar.get(Calendar.YEAR) && selectCalendar.get(Calendar.MONTH) == severCalendar.get(Calendar.MONTH)
				&& selectCalendar.get(Calendar.DAY_OF_MONTH) == severCalendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 *
	 * 描述:对比2个时间是否是开始上课时间
	 *
	 * @author louwj
	 * @created 2014-12-9 下午6:52:44
	 * @param csList
	 * @return
	 * @return boolean
	 */
	public static boolean checkTime(Date selectDate, Date date2) {
		if (selectDate == null || date2 == null) {
			return false;
		}
		Calendar selectCalendar = Calendar.getInstance();
		selectCalendar.setTime(selectDate);
		Calendar severCalendar = Calendar.getInstance();
		severCalendar.setTime(date2);
		return selectCalendar.get(Calendar.YEAR) == severCalendar.get(Calendar.YEAR) && selectCalendar.get(Calendar.MONTH) == severCalendar.get(Calendar.MONTH)
				&& selectCalendar.get(Calendar.DAY_OF_MONTH) == severCalendar.get(Calendar.DAY_OF_MONTH) && selectCalendar.get(Calendar.HOUR_OF_DAY) >= severCalendar.get(Calendar.HOUR_OF_DAY)
				&& selectCalendar.get(Calendar.MINUTE) >= severCalendar.get(Calendar.MINUTE);
	}
}
