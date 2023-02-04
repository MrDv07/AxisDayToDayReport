package com.axis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<String> myException(IdNotFoundException exception){
    return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
   
   
    @ExceptionHandler(InValidAgeException.class)
	   ResponseEntity<String> myException(InValidAgeException exception1){
	   return new ResponseEntity<String>(exception1.getMsg(), HttpStatus.NOT_FOUND);
	      
   }
    
    
    @ExceptionHandler(InValidSalaryException.class)
    ResponseEntity<String> myException(InValidSalaryException exception2){
    	return new ResponseEntity<String>(exception2.getMsg() , HttpStatus.NOT_FOUND);
    }
}
