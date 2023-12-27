package com.userservice.controller.user_defined_exception;

public class ResourceAlreadyExitsException extends RuntimeException
{

	public ResourceAlreadyExitsException() {
		super("Resource already exist on server");
		
	}
	public ResourceAlreadyExitsException(String message) {
		super(message);
		
	}
	

	

	
}
