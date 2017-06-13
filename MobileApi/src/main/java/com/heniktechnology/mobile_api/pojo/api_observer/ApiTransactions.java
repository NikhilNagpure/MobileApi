package com.heniktechnology.mobile_api.pojo.api_observer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApiTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionsId;
	private Request request;
	private Response response;
	private String requestTimeStamp;
	private String responseTimeStamp;
	private String userId;
	private String Status;

	public ApiTransactions(Request request, Response response, String requestTimeStamp, String responseTimeStamp,
			String userId, String status) {
		super();
		this.request = request;
		this.response = response;
		this.requestTimeStamp = requestTimeStamp;
		this.responseTimeStamp = responseTimeStamp;
		this.userId = userId;
		Status = status;
	}

	public ApiTransactions(Long transactionsId, Request request, Response response, String requestTimeStamp,
			String responseTimeStamp, String userId, String status) {
		super();
		this.transactionsId = transactionsId;
		this.request = request;
		this.response = response;
		this.requestTimeStamp = requestTimeStamp;
		this.responseTimeStamp = responseTimeStamp;
		this.userId = userId;
		Status = status;
	}

	public ApiTransactions() {
		super();
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setTransactionsId(Long transactionsId) {
		this.transactionsId = transactionsId;
	}

	public String getTransactionsId() {
		return String.valueOf(transactionsId);
	}

	public void setTransactionsId(String transactionsId) {
		this.transactionsId = Long.valueOf(transactionsId);
	}

	public String getRequestTimeStamp() {
		return requestTimeStamp;
	}

	public void setRequestTimeStamp(String requestTimeStamp) {
		this.requestTimeStamp = requestTimeStamp;
	}

	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}

	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "ApiTransactions [transactionsId=" + transactionsId + ", request=" + request + ", response=" + response
				+ ", requestTimeStamp=" + requestTimeStamp + ", responseTimeStamp=" + responseTimeStamp + ", userId="
				+ userId + ", Status=" + Status + "]";
	}

}
