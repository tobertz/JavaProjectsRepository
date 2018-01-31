package com.java.webapp.core.codes.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Access.
 */
public class Access extends CommonFields implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1674513255910388802L;
	
	/** The access id. */
	private Integer accessId;
	
	/** The access code. */
	private String accessCode;
	
	/** The access name. */
	private String accessName;
	
	/** The access base name. */
	private String accessBaseName;
	
	/** The access url. */
	private String accessUrl;
	
	/** The access type id. */
	private Integer accessTypeId;
	
	/** The access level. */
	private Integer accessLevel;
	
	/** The access sequence. */
	private Integer accessSequence;
	
	/** The access group. */
	private Integer accessGroup;
	
	/** The status. */
	private Integer statusId;
	
	/** The parent access id. */
	private Integer parentAccessId;

	/** The access description. */
	private String accessDescription;
	
	/** The access type. */
	private AccessType accessType;
	
	/**
	 * Gets the access id.
	 *
	 * @return the access id
	 */
	public Integer getAccessId() {
		return accessId;
	}

	/**
	 * Sets the access id.
	 *
	 * @param accessId the new access id
	 */
	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}

	/**
	 * Gets the access code.
	 *
	 * @return the access code
	 */
	public String getAccessCode() {
		return accessCode;
	}

	/**
	 * Sets the access code.
	 *
	 * @param accessCode the new access code
	 */
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	/**
	 * Gets the access name.
	 *
	 * @return the access name
	 */
	public String getAccessName() {
		return accessName;
	}

	/**
	 * Sets the access name.
	 *
	 * @param accessName the new access name
	 */
	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	/**
	 * Gets the access base name.
	 *
	 * @return the access base name
	 */
	public String getAccessBaseName() {
		return accessBaseName;
	}

	/**
	 * Sets the access base name.
	 *
	 * @param accessBaseName the new access base name
	 */
	public void setAccessBaseName(String accessBaseName) {
		this.accessBaseName = accessBaseName;
	}

	/**
	 * Gets the access url.
	 *
	 * @return the access url
	 */
	public String getAccessUrl() {
		return accessUrl;
	}

	/**
	 * Sets the access url.
	 *
	 * @param accessUrl the new access url
	 */
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	/**
	 * Gets the access type id.
	 *
	 * @return the access type id
	 */
	public Integer getAccessTypeId() {
		return accessTypeId;
	}

	/**
	 * Sets the access type id.
	 *
	 * @param accessTypeId the new access type id
	 */
	public void setAccessTypeId(Integer accessTypeId) {
		this.accessTypeId = accessTypeId;
	}

	/**
	 * Gets the access level.
	 *
	 * @return the access level
	 */
	public Integer getAccessLevel() {
		return accessLevel;
	}

	/**
	 * Sets the access level.
	 *
	 * @param accessLevel the new access level
	 */
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * Gets the access sequence.
	 *
	 * @return the access sequence
	 */
	public Integer getAccessSequence() {
		return accessSequence;
	}

	/**
	 * Sets the access sequence.
	 *
	 * @param accessSequence the new access sequence
	 */
	public void setAccessSequence(Integer accessSequence) {
		this.accessSequence = accessSequence;
	}

	/**
	 * Gets the access group.
	 *
	 * @return the access group
	 */
	public Integer getAccessGroup() {
		return accessGroup;
	}

	/**
	 * Sets the access group.
	 *
	 * @param accessGroup the new access group
	 */
	public void setAccessGroup(Integer accessGroup) {
		this.accessGroup = accessGroup;
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
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the parent access id.
	 *
	 * @return the parent access id
	 */
	public Integer getParentAccessId() {
		return parentAccessId;
	}

	/**
	 * Sets the parent access id.
	 *
	 * @param parentAccessId the new parent access id
	 */
	public void setParentAccessId(Integer parentAccessId) {
		this.parentAccessId = parentAccessId;
	}

	/**
	 * Gets the access description.
	 *
	 * @return the access description
	 */
	public String getAccessDescription() {
		return accessDescription;
	}

	/**
	 * Sets the access description.
	 *
	 * @param accessDescription the new access description
	 */
	public void setAccessDescription(String accessDescription) {
		this.accessDescription = accessDescription;
	}

	/**
	 * Gets the access type.
	 *
	 * @return the access type
	 */
	public AccessType getAccessType() {
		return accessType;
	}

	/**
	 * Sets the access type.
	 *
	 * @param accessType the new access type
	 */
	public void setAccessType(AccessType accessType) {
		this.accessType = accessType;
	}
	
	
}
