package com.java.webapp.core.codes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.webapp.core.codes.domain.Role;
import com.java.webapp.core.codes.manager.RoleManager;
import com.java.webapp.core.codes.service.RoleService;;

//@Component
public class RoleServiceImpl implements RoleService {

//	@Autowired
	RoleManager roleManager;
	
	public Role getRoleByRoleId(Integer roleId) {
		return roleManager.getRoleByRoleId(roleId);
	}

}
