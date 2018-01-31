package com.java.webapp.core.codes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.manager.ParameterManager;
import com.java.webapp.core.codes.service.ParameterService;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	ParameterManager parameterManager;
	
	public Integer getParameterIntValueFromName(String paramName) throws CustomExceptionHandler {
		try {
			return parameterManager.getParameterIntValueFromName(paramName);
		} catch (CustomExceptionHandler e) {
			System.out.println(e.getExceptionCode() + " :: " + e.getExceptionMsg());
			throw e;
		}
		
	}

}
