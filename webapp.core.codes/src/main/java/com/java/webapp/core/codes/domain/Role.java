package com.java.webapp.core.codes.domain;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 */
public class Role extends CommonFields implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1544513255910388802L;

	/** The role id. */
	private Integer roleId;

	/** The role code. */
	private String roleCode;

	/** The role name. */
	private String roleName;

	/** The role level. */
	private String roleLevel;

	/** The status. */
	private Integer statusId;
	
	/** The is visible. */
	private boolean isVisible;
	
	/** The role description. */
	private String roleDescription;
	
	/** The status. */
	private Status status;
	
	/** The access list. */
	private List<Access> accessList;

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
	 * Gets the role code.
	 *
	 * @return the role code
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * Sets the role code.
	 *
	 * @param roleCode the new role code
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the role level.
	 *
	 * @return the role level
	 */
	public String getRoleLevel() {
		return roleLevel;
	}

	/**
	 * Sets the role level.
	 *
	 * @param roleLevel the new role level
	 */
	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * Sets the visible.
	 *
	 * @param isVisible the new visible
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * Gets the role description.
	 *
	 * @return the role description
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * Sets the role description.
	 *
	 * @param roleDescription the new role description
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets the access list.
	 *
	 * @return the access list
	 */
	public List<Access> getAccessList() {
		return accessList;
	}

	/**
	 * Sets the access list.
	 *
	 * @param accessList the new access list
	 */
	public void setAccessList(List<Access> accessList) {
		this.accessList = accessList;
	}
	
}
