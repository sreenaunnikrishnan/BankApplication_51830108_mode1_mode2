package com.bankapp.web.controller.bean;

public class DepositWithdrawResponse {
	private Long accountNumber;
	private double amount;
	private String transactionType;
	private String authorityName;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	public DepositWithdrawResponse(Long accountNumber, double amount,
			String transactionType, String authorityName) {
		
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionType = transactionType;
		this.authorityName = authorityName;
	}
	public DepositWithdrawResponse() {
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "TransactionResponse [accountNumber=" + accountNumber
				+ ", amount=" + amount + ", transactionType=" + transactionType
				+ ", authorityName=" + authorityName + "]";
	}
	
	
	

}
