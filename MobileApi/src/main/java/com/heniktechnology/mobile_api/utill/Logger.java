package com.heniktechnology.mobile_api.utill;

public class Logger {

	private static boolean loggerEnabled = false;

	public static void log(String TAG, String... strings) {
		System.out.println("-----------------START--------------------");
		System.out.print(TAG + "  :  ");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println("-----------------END--------------------");
	}

	public static void enabledLogger(boolean enabled) {

		 loggerEnabled = enabled;
	}

	public static boolean isLoggerEnabled() {

		return loggerEnabled;
	}

}
