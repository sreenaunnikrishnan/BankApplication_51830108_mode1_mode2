package com.bankapp.web.controller.bean;

public class TransferResponse {
	
	public Long fromAcc;
	public Long toAcc;
	public String transactionType;
	public double amount;
	public String authotityName;
	public Long getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(Long fromAcc) {
		this.fromAcc = fromAcc;
	}
	public Long getToAcc() {
		return toAcc;
	}
	public void setToAcc(Long toAcc) {
		this.toAcc = toAcc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransferResponse() {
		
	}
	public TransferResponse(Long fromAcc, Long toAcc, String transactionType,
			double amount, String authotityName) {
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.transactionType = transactionType;
		this.amount = amount;
		this.authotityName = authotityName;
	}
	
	

}
