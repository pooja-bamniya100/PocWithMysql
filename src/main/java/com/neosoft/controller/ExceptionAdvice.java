package com.neosoft.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.neosoft.exception.PasswordNotMatchException;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.EmployeeError;

@ControllerAdvice
public class ExceptionAdvice {
	 
      @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<EmployeeError> mapException(ResourceNotFoundException ex)
	{
		EmployeeError error =new EmployeeError(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<EmployeeError>(error,HttpStatus.NOT_FOUND) ;
		}
      
      
      @ExceptionHandler(PasswordNotMatchException.class)
  	 public ResponseEntity<EmployeeError> mapException(PasswordNotMatchException ex)
  	{
  		EmployeeError error =new EmployeeError(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage());
  		return new ResponseEntity<EmployeeError>(error,HttpStatus.NOT_ACCEPTABLE) ;
  		}
      
      @ExceptionHandler(ValidationException.class)
   	 public ResponseEntity<EmployeeError> mapException(ValidationException ex)
   	{ 
    	EmployeeError error =new EmployeeError(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
   		return new ResponseEntity<EmployeeError>(error,HttpStatus.BAD_REQUEST) ;
   		}
     
      @ExceptionHandler(NumberFormatException.class)
    	 public ResponseEntity<EmployeeError> mapException(NumberFormatException ex)
    	{ 
     	EmployeeError error =new EmployeeError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"id cannot be null please enter any valid id");
    		return new ResponseEntity<EmployeeError>(error,HttpStatus.INTERNAL_SERVER_ERROR) ;
    		}
//      @ExceptionHandler(Exception.class)
//   	 public ResponseEntity<EmployeeError> mapException(Exception ex)
//   	{
//   		EmployeeError error =new EmployeeError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
//   		return new ResponseEntity<EmployeeError>(error,HttpStatus.INTERNAL_SERVER_ERROR) ;
//   		}
}
