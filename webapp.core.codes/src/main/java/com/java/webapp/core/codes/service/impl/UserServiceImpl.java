package com.java.webapp.core.codes.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.webapp.core.codes.domain.User;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;
import com.java.webapp.core.codes.manager.UserManager;
import com.java.webapp.core.codes.service.UserService;
import com.java.webapp.core.codes.util.Constants;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserManager userManager;
	
	public Integer validateUserLogin(String username, String password) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		User user = null;
		params.put("username", username);
		params.put("password", password);
		try {
			Integer validateUser = userManager.validateUserLogin(params);
			return validateUser;
		} catch(CustomExceptionHandler e) {
			e.printStackTrace();
			throw new CustomExceptionHandler(e.getExceptionCode(), e.getExceptionMsg());
		}
	}

	public Integer getConnection() throws CustomExceptionHandler {
		return null;
	}

	public User getUserByUsername(String username) {
		return userManager.getUserByUsername(username);
	}

}
