package com.bankapp.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.entities.Customer;

public interface AccountService {
	public List<Account> getAllAccounts();
	public void blockAccount(Long accountNumber);
	public Account createAccount(Account account );
	public void deposit(Long accountNumber, double amount);
	public void withdraw(Long accountNumber, double amount);
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount);
	public Account getAccountById(Long accountNumber);
	public void deleteAccount(Long accountNumber) ;
	public Account updateAccount(Long accountNumber, Account account);
	
	
	public Customer findCustomerByName(String name);
	public Customer findByCustomerCustomerId(Long custId);
	public List<Customer> findAllCustomers();
	public Customer updateCustomer(Long accountNumber,Customer customer);
	
	
}
