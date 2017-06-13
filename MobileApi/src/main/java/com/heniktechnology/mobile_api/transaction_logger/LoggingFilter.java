/*
 * spring-mvc-logger logs requests/responses
 *
 * Copyright (c) 2013. Israel Zalmanov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.heniktechnology.mobile_api.transaction_logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.heniktechnology.mobile_api.ApiController;
import com.heniktechnology.mobile_api.pojo.api_observer.ApiTransactions;
import com.heniktechnology.mobile_api.pojo.api_observer.ApiTransactionsService;
import com.heniktechnology.mobile_api.pojo.api_observer.Request;
import com.heniktechnology.mobile_api.pojo.api_observer.Response;
import com.heniktechnology.mobile_api.utill.DateTimeManager;
import com.heniktechnology.mobile_api.utill.Logger;
import com.mysql.fabric.xmlrpc.base.Data;

import static com.heniktechnology.mobile_api.utill.Logger.log;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class LoggingFilter extends OncePerRequestFilter {

	private static final String REQUEST_PREFIX = "Request: ";
	private static final String RESPONSE_PREFIX = "Response: ";
	private AtomicLong id = new AtomicLong(1);
	private String TAG = LoggingFilter.class.getSimpleName();

	@Autowired()
	private ApiTransactionsService apiTransactionsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {

		long requestId = 0;

		if (Logger.isLoggerEnabled()) {

			requestId = id.incrementAndGet();
			request = new RequestWrapper(requestId, request);
			response = new ResponseWrapper(requestId, response);
		}
		try {
			filterChain.doFilter(request, response);
			// response.flushBuffer();
		} finally {

			if (ApiController.ADMIN_ENABLE_REQUEST_RESPONCE_STORE) {
				ApiTransactions apiTransactions = new ApiTransactions(requestId, logRequest(request),
						logResponse((ResponseWrapper) response), String.valueOf(DateTimeManager.getTimeStamp()),
						String.valueOf(DateTimeManager.getTimeStamp()), "NA", String.valueOf(response.getStatus()));
				log(TAG, "apiTransactions : " + apiTransactions.toString());
			}

		}

	}

	private Request logRequest(final HttpServletRequest request) {

		StringBuilder msg = new StringBuilder();

		msg.append(REQUEST_PREFIX);
		if (request instanceof RequestWrapper) {
			msg.append("request id=").append(((RequestWrapper) request).getId()).append("; ");
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			msg.append("session id=").append(session.getId()).append("; ");
		}
		if (request.getMethod() != null) {
			msg.append("method=").append(request.getMethod()).append("; ");
		}
		if (request.getContentType() != null) {
			msg.append("content type=").append(request.getContentType()).append("; ");
		}
		msg.append("uri=").append(request.getRequestURI());
		if (request.getQueryString() != null) {
			msg.append('?').append(request.getQueryString());
		}

		if (request instanceof RequestWrapper && !isMultipart(request) && !isBinaryContent(request)) {
			RequestWrapper requestWrapper = (RequestWrapper) request;
			try {
				String charEncoding = requestWrapper.getCharacterEncoding() != null
						? requestWrapper.getCharacterEncoding() : "UTF-8";
				String payload = new String(requestWrapper.toByteArray(), charEncoding);
				if (!payload.trim().equals("")) {
					msg.append("; payload=").append(new String(requestWrapper.toByteArray(), charEncoding));
				}

			} catch (UnsupportedEncodingException e) {
				log(TAG, "Failed to parse request payload", e.toString());
			}

		}
		log(TAG, msg.toString());

		return new Request(request);
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

	private Response logResponse(final ResponseWrapper response) {
		StringBuilder msg = new StringBuilder();
		msg.append(RESPONSE_PREFIX);
		msg.append("request id=").append((response.getId()));
		try {
			msg.append("; payload=").append(new String(response.toByteArray(), response.getCharacterEncoding()));
		} catch (UnsupportedEncodingException e) {
			log(TAG, "Failed to parse response payload", e.toString());
		}
		log(TAG, msg.toString());

		return new Response(response);
	}

}
