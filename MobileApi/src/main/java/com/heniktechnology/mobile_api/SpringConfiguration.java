package com.heniktechnology.mobile_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heniktechnology.mobile_api.transaction_logger.LoggingFilter;


@EnableAutoConfiguration 
@Configuration
public class SpringConfiguration {

	@Autowired
	private LoggingFilter loggingFilter;
	
	 @Bean 
	    public FilterRegistrationBean LoggingFilterBean() { 
	        final FilterRegistrationBean registrationBean = new FilterRegistrationBean(); 
	        registrationBean.setFilter(loggingFilter); 
	        registrationBean.addUrlPatterns("/*"); 
	        return registrationBean; 
	    } 
	 
	 
	 @Bean 
	    public BasicInitializerBean BasicInitializer() { 
	        final BasicInitializerBean initializerBean = new BasicInitializerBean(); 
	        initializerBean.setFilter(loggingFilter); 
	        initializerBean.addUrlPatterns("/*"); 
	        return initializerBean; 
	    } 
	 
	
}
