package com.example.springmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String id) {
		super("Ressource not found. Id: " + id);
	}

}
