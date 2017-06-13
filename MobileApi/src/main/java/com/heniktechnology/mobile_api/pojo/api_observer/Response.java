package com.heniktechnology.mobile_api.pojo.api_observer;

import static com.heniktechnology.mobile_api.utill.Logger.log;

import java.io.UnsupportedEncodingException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.heniktechnology.mobile_api.transaction_logger.ResponseWrapper;

@Embeddable
public class Response {
	@Transient
	private String TAG = Response.class.getSimpleName();
	private String responseId = "";
	private String payloadResponce = "";

	
	
	public Response(final ResponseWrapper response) {
		super();
	
		responseId = String.valueOf(response.getId());
		try {
			 payloadResponce=new String(response.toByteArray(), response.getCharacterEncoding());
		} catch (UnsupportedEncodingException e) {
			log(TAG, "Failed to parse response payload", e.toString());
		}
		log(TAG, toString());

	}
	
	public Response() {
		super();
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getPayload() {
		return payloadResponce;
	}

	public void setPayload(String payload) {
		this.payloadResponce = payload;
	}

	@Override
	public String toString() {
		return "Response [TAG=" + TAG + ", responseId=" + responseId + ", payload=" + payloadResponce + "]";
	}
	
	

}
