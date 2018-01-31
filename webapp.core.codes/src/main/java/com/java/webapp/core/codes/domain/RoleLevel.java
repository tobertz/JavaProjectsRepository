package com.java.webapp.core.codes.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleLevel.
 */
public class RoleLevel extends CommonFields implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2674513255910388802L;
	
	/** The role level id. */
	private Integer roleLevelId;
	
	/** The role level code. */
	private String roleLevelCode;
	
	/** The role level name. */
	private String roleLevelName;

	/**
	 * Gets the role level id.
	 *
	 * @return the role level id
	 */
	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	/**
	 * Sets the role level id.
	 *
	 * @param roleLevelId the new role level id
	 */
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	/**
	 * Gets the role level code.
	 *
	 * @return the role level code
	 */
	public String getRoleLevelCode() {
		return roleLevelCode;
	}

	/**
	 * Sets the role level code.
	 *
	 * @param roleLevelCode the new role level code
	 */
	public void setRoleLevelCode(String roleLevelCode) {
		this.roleLevelCode = roleLevelCode;
	}

	/**
	 * Gets the role level name.
	 *
	 * @return the role level name
	 */
	public String getRoleLevelName() {
		return roleLevelName;
	}

	/**
	 * Sets the role level name.
	 *
	 * @param roleLevelName the new role level name
	 */
	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}
	
}
