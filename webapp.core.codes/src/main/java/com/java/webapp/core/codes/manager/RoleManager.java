package com.java.webapp.core.codes.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.webapp.core.codes.domain.Role;
import com.java.webapp.core.codes.exception.CustomExceptionHandler;

//@Component
public class RoleManager extends BaseManager{

	@Autowired
	RoleDao roleDao;
	
	public RoleManager() {
		super();
	}
	
	public RoleManager(MyBatisConnectionManager connectionManager) throws CustomExceptionHandler {
		super(connectionManager);
	}
	
	
	public Role getRoleByRoleId(Integer roleId) {
		return roleDao.getRoleByRoleId(roleId);
	}
	
}
