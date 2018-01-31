package com.java.webapp.core.codes.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Status.
 */
public class Status extends CommonFields implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1674513255910388802L;
	
	/** The status id. */
	private Integer statusId;
	
	/** The status name. */
	private String statusName;
	
	/** The status code. */
	private String statusCode;

	/** The status description. */
	private String statusDescription;

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
	 * Gets the status name.
	 *
	 * @return the status name
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * Sets the status name.
	 *
	 * @param statusName the new status name
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the status description.
	 *
	 * @return the status description
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * Sets the status description.
	 *
	 * @param statusDescription the new status description
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	 
}
