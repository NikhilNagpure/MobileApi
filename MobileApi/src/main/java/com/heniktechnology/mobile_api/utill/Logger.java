package com.heniktechnology.mobile_api.utill;

public class Logger {
	
	public  static void log(String TAG, String ...strings)
	{
		System.out.println("-----------------START--------------------");
		System.out.print(TAG+"  :  ");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println("-----------------END--------------------");
	}

}
