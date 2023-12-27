package com.userservice.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userservice.controller.user_defined_exception.ResourceAlreadyExitsException;
import com.userservice.controller.user_defined_exception.ResourceNotFoundException;
import com.userservice.response.ApiResponse;

@ControllerAdvice
public class userExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> HandleResourceNotFoundException(ResourceNotFoundException e)
	{
		ApiResponse response=ApiResponse.builder().message(e.getMessage()).isSuccess(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAlreadyExitsException.class)
	public ResponseEntity<ApiResponse> HandleResourceExistException(ResourceAlreadyExitsException e)
	{
		ApiResponse response=ApiResponse.builder().message(e.getMessage()).isSuccess(true).status(HttpStatus.CONFLICT).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) 
	{
		return e.getMessage();
	}
}
