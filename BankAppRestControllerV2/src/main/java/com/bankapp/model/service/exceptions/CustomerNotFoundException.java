package com.bankapp.model.service.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3842333490493537734L;
	
	public CustomerNotFoundException(Long custId) {
		super("Customer with customerId: "+ custId +" was not found");
	}

}
