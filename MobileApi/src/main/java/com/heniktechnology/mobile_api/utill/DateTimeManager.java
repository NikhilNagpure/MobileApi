package com.heniktechnology.mobile_api.utill;

import java.util.Date;

public class DateTimeManager {
	
	public static long getTimeStamp() {
		return new Date().getTime();
	}

}
