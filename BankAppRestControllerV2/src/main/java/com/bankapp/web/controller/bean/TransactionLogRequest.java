package com.bankapp.web.controller.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionLogRequest {
	private LocalDate fromDate;
	private  LocalDate toDate;
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	


}
