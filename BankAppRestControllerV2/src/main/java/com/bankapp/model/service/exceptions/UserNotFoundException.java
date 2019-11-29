package com.bankapp.model.service.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long userId) {
		super("User with userId:" + userId +" was not found");
	}

}
