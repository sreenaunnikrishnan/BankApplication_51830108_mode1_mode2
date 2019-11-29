package com.bankapp.model.service.exceptions;

public class NotSufficientFundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotSufficientFundException(Long accountNumber) {
		super("Account with accountNumber:" + accountNumber + " doees not contain minimum balance");
		
	}

}
