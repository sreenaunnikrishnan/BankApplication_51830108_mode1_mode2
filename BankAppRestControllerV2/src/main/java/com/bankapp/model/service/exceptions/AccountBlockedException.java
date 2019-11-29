package com.bankapp.model.service.exceptions;

public class AccountBlockedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountBlockedException(Long accountNumber) {
		super("The account with ccountNumber:" + accountNumber + " is Blocked");
		
	}

}
