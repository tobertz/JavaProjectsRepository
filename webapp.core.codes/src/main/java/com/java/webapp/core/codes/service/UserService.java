package com.java.webapp.core.codes.service;

import com.java.webapp.core.codes.domain.User;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;

public interface UserService extends BaseService {

	Integer validateUserLogin(String username, String password) throws CustomExceptionHandler;

	User getUserByUsername(String username);

}
