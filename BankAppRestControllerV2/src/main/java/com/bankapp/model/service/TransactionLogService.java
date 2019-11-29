package com.bankapp.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bankapp.model.entities.AccountTransactionLog;

public interface TransactionLogService {
	public List<AccountTransactionLog> getTransactionLogByDate(LocalDateTime fromDate , LocalDateTime toDate);
	public List<AccountTransactionLog> getTransactionLogForAccount(Long accountNumber);
	public List<AccountTransactionLog> getTransactionLog();

	
}
