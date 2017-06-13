package com.heniktechnology.mobile_api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heniktechnology.mobile_api.transaction_logger.LoggingFilter;


@EnableAutoConfiguration 
@Configuration 
public class SpringConfiguration {

	
	 @Bean 
	    public FilterRegistrationBean LoggingFilterBean() { 
	        final FilterRegistrationBean registrationBean = new FilterRegistrationBean(); 
	        registrationBean.setFilter(new LoggingFilter()); 
	        registrationBean.addUrlPatterns("/*"); 
	        return registrationBean; 
	    } 
	
}
