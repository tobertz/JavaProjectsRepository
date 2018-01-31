package com.java.webapp.core.codes.service;

import com.java.webapp.core.codes.exception.CustomExceptionHandler;

public interface ParameterService {

	public Integer getParameterIntValueFromName(String paramName) throws CustomExceptionHandler;
	
}
