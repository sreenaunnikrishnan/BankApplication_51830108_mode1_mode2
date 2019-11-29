package com.bankapp.model.service.exceptions;

public class AccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountNotFoundException(Long accountNumber) {
		super("Account with accountNumber:" + accountNumber + " was not found");
		
	}

}
