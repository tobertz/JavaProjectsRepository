package com.java.webapp.core.codes.domain;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User extends CommonFields implements Serializable { 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3544513255910388802L;
	
	/** The user id. */
	public Integer userId;
	
	/** The username. */
	public String username;
	
	/** The password. */
	public String password;
	
	/** The status. */
	public Integer statusId;
	
	/** The role id. */
	public Integer roleId;
	
	/** The last login. */
	public Date lastLogin;
	
	/** The parent user id. */
	public Integer parentUserId;
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatusId() {
		return statusId;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public Date getLastLogin() {
		return lastLogin;
	}
	
	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	/**
	 * Gets the parent user id.
	 *
	 * @return the parent user id
	 */
	public Integer getParentUserId() {
		return parentUserId;
	}
	
	/**
	 * Sets the parent user id.
	 *
	 * @param parentUserId the new parent user id
	 */
	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}
		
}
