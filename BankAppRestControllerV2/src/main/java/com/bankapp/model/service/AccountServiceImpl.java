package com.bankapp.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionLogRepository;
import com.bankapp.model.repo.AccountTransationRepository;
import com.bankapp.model.service.exceptions.AccountBlockedException;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepo;
	

	@Autowired
	private AccountTransactionLogRepository transactionLogRepo;
	
	@Autowired
	private AccountTransationRepository transactionRepo;
	
	@Override
	public void blockAccount(Long accountNumber) {
		Account account =getAccountById(accountNumber);
		account.setBlocked(true);
		accountRepo.save(account);

	}

	@Override
	public Account createAccount(Account account) {
		Address address = account.getCustomer().getAddress();
		account.getCustomer().setAccount(account);
		account.getCustomer().setAddress(address);
		address.setCustomer(account.getCustomer());
		accountRepo.save(account);
		return account;
		
	}

	
	@Override
	public Account getAccountById(Long accountNumber) {
	
		return accountRepo.findById(accountNumber).orElseThrow(()-> new AccountNotFoundException(accountNumber));
	}
	
	@Override
	public void deposit(Long accountNumber, double amount) {
		
		
		Account account = getAccountById(accountNumber);
	
		if(account.isBlocked()== true)
			throw new AccountBlockedException(accountNumber);
			
		account.setBalance(account.getBalance()+amount);
	
		
		AccountTransaction accountTransaction = new AccountTransaction("DEPOSIT", amount);
		account.addAccountTransaction(accountTransaction);
		
		accountRepo.save(account);
		
		
		AccountTransactionLog transactionLog = new AccountTransactionLog(null, accountNumber, "DEPOSIT", amount, "Daniel", "APPROVED");
		transactionLogRepo.save(transactionLog);
		
		
		
		
	}

	@Override
	public void withdraw(Long accountNumber, double amount) {

		Account account = getAccountById(accountNumber);

		
		if(account.isBlocked()== true)
			throw new AccountBlockedException(accountNumber);
		
		account.setBalance(account.getBalance()-amount);
		
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException(accountNumber);
		
		AccountTransaction accountTransaction = new AccountTransaction("WITHDRAW", amount);
		account.addAccountTransaction(accountTransaction);
		
		accountRepo.save(account);
		
		AccountTransactionLog transactionLog = new AccountTransactionLog( accountNumber,null, "WITHDRAW", amount, "Daniel", "APPROVED");
		transactionLogRepo.save(transactionLog);
		
		
	}

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount) {
		this.withdraw(fromAccNumber, amount);
		this.deposit(toAccNumber, amount);
		
	}

	@Override
	public List<Account> getAllAccounts() {
	
		return accountRepo.findAll();
		
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepo.deleteById(accountNumber);
		
	}

	@Override
	public Account updateAccount(Long accountNumber, Account account) {
		Account accountToBeUpdated = getAccountById(accountNumber);
		accountToBeUpdated.setBlocked(account.isBlocked());
		accountRepo.save(accountToBeUpdated);
		return accountToBeUpdated;
	}



	@Override
	public Customer findCustomerByName(String name) {
		
		return accountRepo.findByCustomerName(name);
	}

	@Override
	public Customer findByCustomerCustomerId(Long custId) {
		
		return accountRepo.findByCustomerCustomerId(custId);
	}

	@Override
	public Customer updateCustomer(Long accountNumber, Customer customer) {
		Account accountToBeUpdated = getAccountById(accountNumber);
		Customer customerToBeUpdated = accountToBeUpdated.getCustomer();
		
		customerToBeUpdated.setEmail(customer.getEmail());
		customerToBeUpdated.setPhone(customer.getPhone());
		customerToBeUpdated.setAddress(customer.getAddress());
		
		accountRepo.save(accountToBeUpdated);
		return customerToBeUpdated;
	}

	@Override
	public List<Customer> findAllCustomers() {

		return accountRepo.findAll().stream().map(a->a.getCustomer()).collect(Collectors.toList());
	}

	

}
