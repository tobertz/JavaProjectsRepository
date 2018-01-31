package com.java.webapp.core.codes.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessType.
 */
public class AccessType extends CommonFields implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5544513255910388803L;
	
	/** The access type id. */
	private Integer accessTypeId;
	
	/** The access type code. */
	private String accessTypeCode;
	
	/** The access type name. */
	private String accessTypeName;
	
	/** The status id. */
	private Integer statusId;
	
	/** The status. */
	private Status status;

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
	 * Gets the access type code.
	 *
	 * @return the access type code
	 */
	public String getAccessTypeCode() {
		return accessTypeCode;
	}

	/**
	 * Sets the access type code.
	 *
	 * @param accessTypeCode the new access type code
	 */
	public void setAccessTypeCode(String accessTypeCode) {
		this.accessTypeCode = accessTypeCode;
	}

	/**
	 * Gets the access type name.
	 *
	 * @return the access type name
	 */
	public String getAccessTypeName() {
		return accessTypeName;
	}

	/**
	 * Sets the access type name.
	 *
	 * @param accessTypeName the new access type name
	 */
	public void setAccessTypeName(String accessTypeName) {
		this.accessTypeName = accessTypeName;
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
	
	
}
