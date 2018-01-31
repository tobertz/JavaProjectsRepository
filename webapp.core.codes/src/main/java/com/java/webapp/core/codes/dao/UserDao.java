package com.java.webapp.core.codes.dao;

import java.util.HashMap;

import com.java.webapp.core.codes.domain.User;

public interface UserDao {

	public User getUserById(HashMap<String, Object> params);
	
	public User validateUserLogin(HashMap<String, Object> params);

	public Integer updateLastLogin(Integer userId);

	public Integer insertLoginHistory(HashMap<String, Object> loginParams);

	public String checkUsername(HashMap<String, Object> params);

	public User getUserByUsername(HashMap<String, Object> params);

	public Integer getLoginCount(Integer loginAttemptLimit);

	public Integer updateUserStatus(HashMap<String, Object> loginParams);

}
