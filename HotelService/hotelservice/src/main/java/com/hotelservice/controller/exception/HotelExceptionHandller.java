package com.hotelservice.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotelservice.response.ApiResponse;
import com.hotelservice.user_defined_exceptions.HotelExitsException;
import com.hotelservice.user_defined_exceptions.HotelNotFoundException;

@ControllerAdvice
public class HotelExceptionHandller 
{

	@ExceptionHandler(HotelExitsException.class)
	public ResponseEntity<ApiResponse> handleHotelExistException(HotelExitsException e)
	{
		ApiResponse response=ApiResponse.builder().message(e.getMessage()).isSuccess(true).status(HttpStatus.CONFLICT).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> handleHotelNotFoundException(HotelNotFoundException e)
	{
		ApiResponse response=ApiResponse.builder().message(e.getMessage()).isSuccess(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}

