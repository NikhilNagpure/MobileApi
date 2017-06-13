package com.heniktechnology.mobile_api.pojo.admin.control;

public class AdminControl {

	private String enableApi;

	private String adminMessage;

	private String enableLogger;

	private String requastResponceStore;

	public AdminControl(String enableApi, String adminMessage, String enableLogger, String requastResponceStore) {
		super();
		this.enableApi = enableApi;
		this.adminMessage = adminMessage;
		this.enableLogger = enableLogger;
		this.requastResponceStore = requastResponceStore;
	}

	public String getEnableApi() {
		return enableApi;
	}

	public void setEnableApi(String enableApi) {
		this.enableApi = enableApi;
	}

	public String getAdminMessage() {
		return adminMessage;
	}

	public void setAdminMessage(String adminMessage) {
		this.adminMessage = adminMessage;
	}

	public String getEnableLogger() {
		return enableLogger;
	}

	public void setEnableLogger(String enableLogger) {
		this.enableLogger = enableLogger;
	}

	public String getRequastResponceStore() {
		return requastResponceStore;
	}

	public void setRequastResponceStore(String requastResponceStore) {
		this.requastResponceStore = requastResponceStore;
	}

	@Override
	public String toString() {
		return "AdminControl [enableApi=" + enableApi + ", adminMessage=" + adminMessage + ", enableLogger="
				+ enableLogger + ", requastResponceStore=" + requastResponceStore + "]";
	}

}
