package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="account_table")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	
	
	private double balance;
	
	
	private boolean blocked;
	
	
	@OneToOne(mappedBy="account",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Customer customer;
	

	@OneToMany(mappedBy="account", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<AccountTransaction> transactionList = new ArrayList<>();

	public Account() {
	
	}

	public Account(double balance, boolean blocked, Customer customer) {
		this.balance = balance;
		this.blocked = blocked;
		this.customer = customer;
	}
	
	public void addAccountTransaction(AccountTransaction tx){
		transactionList.add(tx);
		tx.setAccount(this);
	}

	public List<AccountTransaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<AccountTransaction> transactionList) {
		this.transactionList = transactionList;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setAccount(this);
	}
	
	
}
