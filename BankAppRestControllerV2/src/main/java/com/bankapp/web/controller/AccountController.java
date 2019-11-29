package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.bean.AccountRequest;
import com.bankapp.web.controller.bean.CustomerRequest;
import com.bankapp.web.controller.bean.DepositWithdrawRequest;
import com.bankapp.web.controller.bean.DepositWithdrawResponse;
import com.bankapp.web.controller.bean.TransferRequest;
import com.bankapp.web.controller.bean.TransferResponse;

@RestController
@RequestMapping(path = "api")
public class AccountController {

	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;

	}

	@GetMapping(path = "account")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return new ResponseEntity<List<Account>>(
				accountService.getAllAccounts(), HttpStatus.OK);
	}

	@GetMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAnAccount(
			@PathVariable(name = "id") Long id) {
		Account account = accountService.getAccountById(id);

		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PostMapping(path = "account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(
			@RequestBody AccountRequest request) {
		Address address = new Address(request.getAddressLine1(),
				request.getStreet(), request.getCity(), request.getState(),
				request.getPostalcode());
		Customer customer = new Customer(request.getName(), request.getEmail(),
				request.getPhone(), address);
		/*address.setCustomer(customer);*/
		

		Account account = new Account(request.getBalance(), false, customer);
		/*customer.setAccount(account);*/
		return new ResponseEntity<Account>(
				accountService.createAccount(account), HttpStatus.OK);
	}

	@DeleteMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAccountById(
			@PathVariable(name = "id") Long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "account/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(
			@PathVariable(name = "id") Long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(id,
				account), HttpStatus.OK);
	}
	
	

	
	//Customer CRUD 
	
	@GetMapping(path = "customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(accountService.findAllCustomers(), HttpStatus.OK);
	}

	
	@GetMapping(path = "customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getACustomerById(@PathVariable(name = "id") long id) {

		return new ResponseEntity<Customer>(accountService.findByCustomerCustomerId(id), HttpStatus.OK);
	}

	
	@PutMapping(path = "customer/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(name = "id") long accountNumber,
			@RequestBody CustomerRequest request) {
		Address address = new Address(request.getAddressLine1(), request.getStreet(), request.getCity(),
				request.getState(), request.getPostalcode());

		Customer customer = new Customer(request.getName(), request.getEmail(), request.getPhone(), address);
		address.setCustomer(customer);
		return new ResponseEntity<Customer>(accountService.updateCustomer(accountNumber, customer), HttpStatus.OK);
		//add a response
	}
	
	
	

	


}