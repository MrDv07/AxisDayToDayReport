package com.axis.exception;

public class InValidAgeException extends RuntimeException {

	String msg; 
	
	public InValidAgeException(String msg) {
		super();
		this.msg = msg;
		} 
	
	public String getMsg() {
	 return msg;
		}
	
}
