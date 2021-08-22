package com.teste.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(Long Id) {
		super("Resource not found id:"+Id);
	}
	

}
