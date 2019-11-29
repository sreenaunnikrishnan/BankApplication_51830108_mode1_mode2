package com.bankapp.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="acctx_table")
public class AccountTransaction {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
    private LocalDate transactionDate;
    private String type;
    private double amount;

	
	@ManyToOne 	@JoinColumn(name="account_fk")
	private Account account;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	


	public AccountTransaction(String type, double amount, Account account) {
		super();
		this.transactionDate =LocalDate.now();
		this.type = type;
		this.amount = amount;
		this.account = account;
	}


	public AccountTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
