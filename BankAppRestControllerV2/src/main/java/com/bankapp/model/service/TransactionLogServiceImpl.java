package com.bankapp.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{
	
	@Autowired
	private AccountTransactionLogRepository logRepo;
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<AccountTransactionLog> getTransactionLogByDate(
			LocalDateTime fromDate, LocalDateTime toDate) {
		
		return logRepo.getTransactionLogByDate(fromDate, toDate);
	}

	@Override
	public List<AccountTransactionLog> getTransactionLogForAccount(
			Long accountNumber) {
		Account account = accountRepo.findById(accountNumber).orElseThrow(()->new AccountNotFoundException(accountNumber));
		
		return logRepo.findAll().stream().filter(l->l.getToAccount().equals(accountNumber)|| l.getToAccount().equals(accountNumber)).collect(Collectors.toList());
	}

	@Override
	public List<AccountTransactionLog> getTransactionLog() {
		
		return logRepo.findAll();
	}
	



}
