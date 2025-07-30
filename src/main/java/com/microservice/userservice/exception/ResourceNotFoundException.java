package com.microservice.userservice.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
