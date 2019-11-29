package com.bankapp.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_log_table")
public class AccountTransactionLog {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime timeStamp;
	private Long fromAccount;
	private Long toAccount;
	private String txType;
	private double txAmount;
	private String authorityName;
	private String status;
	// Approved, pending
	public AccountTransactionLog() {}
		
	
	public AccountTransactionLog( Long fromAccount,
			Long toAccount, String txType, double txAmount,
			String authorityName, String status) {
		
		setTimeStamp();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.txType = txType;
		this.txAmount = txAmount;
		this.authorityName = authorityName;
		this.status = status;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp() {
		this.timeStamp=LocalDateTime.now();
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public String getTxType() {
		return txType;
	}
	public void setTxType(String txType) {
		this.txType = txType;
	}
	public double getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountTransactionLog [id=" + id + ", timeStamp=" + timeStamp + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", txType=" + txType + ", txAmount=" + txAmount + ", authorityName="
				+ authorityName + ", status=" + status + "]";
	}
	
	

}
