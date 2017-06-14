package com.heniktechnology.mobile_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.heniktechnology.mobile_api.utill.Logger;

@SpringBootApplication
@ComponentScan(basePackages = { "com.heniktechnology.mobile_api", "com.heniktechnology.mobile_api.controllers" })
public class MobileApiApplication {
	
	@Autowired
	private static BasicInitializer basicInitializer;

	public static void main(String[] args) {
		SpringApplication.run(MobileApiApplication.class, args);
		String TAG = MobileApiApplication.class.getSimpleName();
		Logger.enabledLogger(ApiController.ADMIN_ENABLE_LOGGER);
		Logger.log(TAG, " Running ");
		
		basicInitializer.insertValuInDataBase();
	}

}
