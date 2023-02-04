package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<ErrorInfo> myException(IdNotFoundException exception){
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());	
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
   
   
    @ExceptionHandler(InValidAgeException.class)
	   ResponseEntity<ErrorInfo> myException(InValidAgeException exception1){
    	
    	
    	ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception1.getMsg());
		errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	      
   }
    
    
    @ExceptionHandler(InValidSalaryException.class)
    ResponseEntity<ErrorInfo> myException(InValidSalaryException exception2){
    	
    	ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(exception2.getMsg());
		errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setLocalDateTime(LocalDateTime.now());
    	
    	return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
    }
}
