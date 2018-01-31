package com.java.webapp.core.codes.exception;

public class CustomExceptionHandler extends RuntimeException {
	private String exceptionMsg;
	private String exceptionCode;
	  
	public CustomExceptionHandler(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public CustomExceptionHandler(String  exceptionCode, String exceptionMsg) {
		System.out.println(exceptionCode + " :: " + exceptionMsg);  
		this.exceptionMsg = exceptionMsg;
		this.exceptionCode = exceptionCode;
	}
   
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
   
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	
}
