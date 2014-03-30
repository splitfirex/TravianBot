package org.tbot.utils;

import java.util.Date;

public class TimeCalculator {
	public static final long	HOUR	= 3600 * 1000;
	public static final long	MINUTES	= 60 * 1000;
	public static final long	SECONDS	= 1000;
	
	public static long NowPlusTime(int hour, int min, int sec) {
		Date now = new Date();
		
		return now.getTime() + hour * HOUR + min * MINUTES + sec * SECONDS;
	}
}
