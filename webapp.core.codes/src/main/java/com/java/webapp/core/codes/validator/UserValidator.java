package com.java.webapp.core.codes.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.java.webapp.core.codes.domain.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
	}

}
