package com.java.webapp.core.codes.service;

import com.java.webapp.core.codes.exception.CustomExceptionHandler;

public interface BaseService {

	Integer getConnection() throws CustomExceptionHandler;

}
