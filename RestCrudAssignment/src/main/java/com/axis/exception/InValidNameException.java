package com.axis.exception;

public class InValidNameException extends RuntimeException{
	
	
String msg1; 
	
	public InValidNameException(String msg2) {
		super();
		this.msg1 = msg2;
		} 
	
	public String getMsg() {
	 return msg1;
		}
	
}
