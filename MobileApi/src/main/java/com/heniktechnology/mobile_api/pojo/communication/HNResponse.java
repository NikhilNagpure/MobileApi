package com.heniktechnology.mobile_api.pojo.communication;

import java.util.List;

public class HNResponse {

	private String code;
	private String message;
	private String status;
	private List data;

	public HNResponse(String code, String status, String message, List data) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public HNResponse() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", status=" + status + ", data=" + data + "]";
	}

}
