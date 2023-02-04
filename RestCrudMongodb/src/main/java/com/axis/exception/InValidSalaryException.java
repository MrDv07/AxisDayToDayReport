package com.axis.exception;

public class InValidSalaryException extends RuntimeException{
	
	
String msg1; 
	
	public InValidSalaryException(String msg2) {
		super();
		this.msg1 = msg2;
		} 
	
	public String getMsg() {
	 return msg1;
		}
	
	
}
