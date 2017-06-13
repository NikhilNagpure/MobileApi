package com.heniktechnology.mobile_api.pojo.admin.api_acction;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.heniktechnology.mobile_api.pojo.admin.Admin;

public class ApiAdminAcction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer apiAdminAcctionId;

	private String apiActive;

	private String apiMessage;

	private String timeStmap;

	private String ActiveForTime;

	private String StopForTime;

	private String ActiveAfterTime;

	private String StopAfterTime;

	private Admin admin;


	
	
	public ApiAdminAcction() {
		super();
	}

	public ApiAdminAcction(Integer apiAdminAcctionId, String apiActive, String apiMessage, String timeStmap,
			String activeForTime, String stopForTime, String activeAfterTime, String stopAfterTime, Admin admin) {
		super();
		this.apiAdminAcctionId = apiAdminAcctionId;
		this.apiActive = apiActive;
		this.apiMessage = apiMessage;
		this.timeStmap = timeStmap;
		ActiveForTime = activeForTime;
		StopForTime = stopForTime;
		ActiveAfterTime = activeAfterTime;
		StopAfterTime = stopAfterTime;
		this.admin = admin;
	}

	public Integer getApiAdminAcctionId() {
		return apiAdminAcctionId;
	}

	public void setApiAdminAcctionId(Integer apiAdminAcctionId) {
		this.apiAdminAcctionId = apiAdminAcctionId;
	}

	public String getApiActive() {
		return apiActive;
	}

	public void setApiActive(String apiActive) {
		this.apiActive = apiActive;
	}

	public String getApiMessage() {
		return apiMessage;
	}

	public void setApiMessage(String apiMessage) {
		this.apiMessage = apiMessage;
	}

	public String getTimeStmap() {
		return timeStmap;
	}

	public void setTimeStmap(String timeStmap) {
		this.timeStmap = timeStmap;
	}

	public String getActiveForTime() {
		return ActiveForTime;
	}

	public void setActiveForTime(String activeForTime) {
		ActiveForTime = activeForTime;
	}

	public String getStopForTime() {
		return StopForTime;
	}

	public void setStopForTime(String stopForTime) {
		StopForTime = stopForTime;
	}

	public String getActiveAfterTime() {
		return ActiveAfterTime;
	}

	public void setActiveAfterTime(String activeAfterTime) {
		ActiveAfterTime = activeAfterTime;
	}

	public String getStopAfterTime() {
		return StopAfterTime;
	}

	public void setStopAfterTime(String stopAfterTime) {
		StopAfterTime = stopAfterTime;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	

}
