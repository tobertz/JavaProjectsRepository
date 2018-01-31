package com.java.webapp.core.codes.domain;

import java.io.Serializable;

public class Parameter extends CommonFields implements Serializable {
	
	private static final long serialVersionUID = -3544513255910388803L;
	
	private Integer parameterId;
	
	private String parameterName;
	private String parameterStringValue;
	private Integer parameterIntValue;
	
	private Integer status;

	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterStringValue() {
		return parameterStringValue;
	}

	public void setParameterStringValue(String parameterStringValue) {
		this.parameterStringValue = parameterStringValue;
	}

	public Integer getParameterIntValue() {
		return parameterIntValue;
	}

	public void setParameterIntValue(Integer parameterIntValue) {
		this.parameterIntValue = parameterIntValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
