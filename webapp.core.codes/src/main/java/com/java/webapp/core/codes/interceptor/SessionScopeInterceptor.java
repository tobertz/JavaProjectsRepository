package com.java.webapp.core.codes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionScopeInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger logger = Logger.getLogger(SessionScopeInterceptor.class);
	
	private String loginMapping;
	
	public void setLoginMapping(String loginMapping) {
		this.loginMapping=loginMapping;
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("SessionScopeInterceptor :: "+loginMapping);
		return true;
	}

}
