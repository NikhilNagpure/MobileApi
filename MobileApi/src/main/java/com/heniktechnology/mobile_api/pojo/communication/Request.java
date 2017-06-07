package com.heniktechnology.mobile_api.pojo.communication;

import java.util.List;

import com.heniktechnology.mobile_api.pojo.user.UserRegister;

public class Request {
	
	private List<UserRegister> data;

	public List<UserRegister> getData() {
		
		return data;
	}

	public void setData(List<UserRegister> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Request [data=" + data + "]";
	}
	
	
}
