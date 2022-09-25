package com.blog.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		
	}
	
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		System.out.println("Inside ResourceNotFoundException");
	}

}
