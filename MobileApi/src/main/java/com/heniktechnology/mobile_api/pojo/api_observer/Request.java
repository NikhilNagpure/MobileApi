package com.heniktechnology.mobile_api.pojo.api_observer;

import static com.heniktechnology.mobile_api.utill.Logger.log;

import java.io.UnsupportedEncodingException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Type;

import com.heniktechnology.mobile_api.transaction_logger.RequestWrapper;
@Embeddable
public class Request {

	@Transient
	private String TAG = com.heniktechnology.mobile_api.pojo.api_observer.Request.class.getSimpleName();
	private String requestId = "";
	private String sessionId = "";
	private String method = "";
	private String contentType = "";
	private String uri = "";
	@Lob
	private String payloadRequast = "";

	public Request() {
		super();
	}

	public Request(final HttpServletRequest request) {
		super();

		if (request instanceof RequestWrapper) {

			requestId = String.valueOf(((RequestWrapper) request).getId());

		}
		HttpSession session = request.getSession(false);
		if (session != null) {

			sessionId = String.valueOf(session.getId());

		}
		if (request.getMethod() != null) {

			method = request.getMethod();

		}
		if (request.getContentType() != null) {

			contentType = request.getContentType();

		}
		if (!request.getRequestURI().trim().equals("")) {
			
			if (request.getQueryString() != null) {
				
				uri = request.getRequestURI()+'?'+request.getQueryString();
			}
			else {
				uri = request.getRequestURI();
			}
			
		}

		

		if (request instanceof RequestWrapper && !isMultipart(request) && !isBinaryContent(request)) {
			RequestWrapper requestWrapper = (RequestWrapper) request;
			try {
				String charEncoding = requestWrapper.getCharacterEncoding() != null
						? requestWrapper.getCharacterEncoding() : "UTF-8";
				String payload = new String(requestWrapper.toByteArray(), charEncoding);
				if (!payload.trim().equals("")) {
					
					 payload= new String(requestWrapper.toByteArray(), charEncoding);
				}

			} catch (UnsupportedEncodingException e) {
				
				log(TAG, "Failed to parse request payload", e.toString());
			}

		}
		
		log(TAG, toString());

	}
	
	
	
	private boolean isBinaryContent(final HttpServletRequest request) {
		if (request.getContentType() == null) {
			return false;
		}
		return request.getContentType().startsWith("image") || request.getContentType().startsWith("video")
				|| request.getContentType().startsWith("audio");
	}

	private boolean isMultipart(final HttpServletRequest request) {
		return request.getContentType() != null && request.getContentType().startsWith("multipart/form-data");
	}


	public Request(String requestId, String sessionId, String method, String contentType, String uri, String payload) {
		super();
		this.requestId = requestId;
		this.sessionId = sessionId;
		this.method = method;
		this.contentType = contentType;
		this.uri = uri;
		this.payloadRequast = payload;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPayload() {
		return payloadRequast;
	}

	public void setPayload(String payload) {
		this.payloadRequast = payload;
	}

	@Override
	public String toString() {
		return "Request [TAG=" + TAG + ", requestId=" + requestId + ", sessionId=" + sessionId + ", method=" + method
				+ ", contentType=" + contentType + ", uri=" + uri + ", payload=" + payloadRequast + "]";
	}
	
	

}
