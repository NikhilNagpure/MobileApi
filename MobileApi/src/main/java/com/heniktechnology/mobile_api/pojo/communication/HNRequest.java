package com.heniktechnology.mobile_api.pojo.communication;

import java.util.List;

import com.heniktechnology.mobile_api.pojo.user.UserRegister;

public class HNRequest<T> {
	
	private List<T> data;

	public List<T> getData() {
		
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Request [data=" + data + "]";
	}
	
	
}
