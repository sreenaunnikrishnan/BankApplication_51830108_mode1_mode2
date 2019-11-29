package com.bankapp.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="accounttx_table")
public class AccountTransaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	private LocalDate transactionDate;
	private String type;
	private double amount;

	@JsonIgnore
	@JoinColumn(name = "accountNumber_fk")
	@ManyToOne
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountTransaction() {
	}

	public AccountTransaction(String type, double amount) {

		this.transactionDate = LocalDate.now();
		this.type = type;
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

}
