/* Licensed Materials
 * Property of Toyota Motor Philippines
 * Copyright (c) 2012 Toyota Motor Philippines
 * All Rights Reserved
 *
 * Creation Date: Jul 20, 2012 1:38:18 PM
 *
 * History
 * Jul 20, 2012    Initial creation        francis
 */
package com.java.webapp.core.codes.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import com.java.webapp.core.codes.util.Flash;


/**
 * The Class FlashScopeInterceptor.
 */
public class FlashScopeInterceptor implements WebRequestInterceptor {

	/** The logger. */
	private final Logger logger = Logger.getLogger(FlashScopeInterceptor.class);

	/** The flash. */
	@Autowired
	private Flash flash;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.request.WebRequestInterceptor#afterCompletion(org.springframework.web.context
	 * .request.WebRequest, java.lang.Exception)
	 */
	public void afterCompletion(WebRequest request, Exception arg1) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.request.WebRequestInterceptor#postHandle(org.springframework.web.context.request
	 * .WebRequest, org.springframework.ui.ModelMap)
	 */
	public void postHandle(WebRequest request, ModelMap map) throws Exception {
		logger.info("FlashScopeInterceptor :: postHandle");
		final Map<String, ?> messages = flash.getMessages();
		if (messages != null) {
			for (Map.Entry<String, ?> entry : messages.entrySet()) {
				logger.info(entry.getValue());
				request.setAttribute(entry.getKey(), entry.getValue(), WebRequest.SCOPE_REQUEST);
			}
			if (flash.isPost) {
				flash.reset();
				flash.isPost = false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.request.WebRequestInterceptor#preHandle(org.springframework.web.context.request
	 * .WebRequest)
	 */
	public void preHandle(WebRequest request) throws Exception {
		logger.info("FlashScopeInterceptor :: preHandle");
		final Map<String, ?> messages = flash.getMessages();

		if (messages != null) {
			for (Map.Entry<String, ?> entry : messages.entrySet()) {
				logger.info(entry.getValue());
				final String key = "flash" + entry.getKey();
				logger.info(key);
				request.setAttribute(entry.getKey(), entry.getValue(), RequestAttributes.SCOPE_REQUEST);
			}
			flash.reset();
		}

	}

}
