package com.sky.recordcalls.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class Formatter
{
	private static Locale locale = new Locale("en", "US");

	public static String date(long paramLong)
	{
		DecimalFormat localDecimalFormat = new DecimalFormat("00");
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTimeInMillis(paramLong);
		String str1 = "" + localCalendar.get(1);
		String str2 = str1 + localDecimalFormat.format(1 + localCalendar.get(2));
		return str2 + localDecimalFormat.format(localCalendar.get(5));
	}

	public static String date(long paramLong, String separator)
	{
		return new SimpleDateFormat(separator, locale).format(new Date(paramLong));
	}

	public static String date(String separator)
	{
		return datetime(Calendar.getInstance().getTimeInMillis(), separator);
	}

	public static String time(long paramLong)
	{
		DecimalFormat localDecimalFormat = new DecimalFormat("00");
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTimeInMillis(paramLong);
		String str1 = "" + localDecimalFormat.format(localCalendar.get(11));
		String str2 = str1 + localDecimalFormat.format(localCalendar.get(12));
		return str2 + localDecimalFormat.format(localCalendar.get(13));
	}

	public static String datetime(long paramLong, String separator)
	{
		DecimalFormat localDecimalFormat = new DecimalFormat("00");
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTimeInMillis(paramLong);
		String str1 = "" + localCalendar.get(1);
		String str2 = str1 + localDecimalFormat.format(1 + localCalendar.get(2));
		String str3 = str2 + localDecimalFormat.format(localCalendar.get(5));
		String str4 = str3 + separator;
		String str5 = str4 + localDecimalFormat.format(localCalendar.get(11));
		String str6 = str5 + localDecimalFormat.format(localCalendar.get(12));
		return str6 + localDecimalFormat.format(localCalendar.get(13));
	}
}
