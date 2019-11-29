package com.bankapp.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.controller.bean.TransactionLogRequest;

@RestController
@RequestMapping("api")
public class TransactionLogController {
	
	
	@Autowired
	private TransactionLogService logService;
	
	@GetMapping(path = "transactionlog")
	public ResponseEntity<List<AccountTransactionLog>> getTransactionLog(){
		return new ResponseEntity<List<AccountTransactionLog>>(logService.getTransactionLog(),HttpStatus.OK);
	}

	@GetMapping(path="transactionlog/{accountNumber}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransactionLog>> getTransactionLogByAccountId(@PathVariable(name="accountNumber") Long accountNumber){

		return new ResponseEntity<List<AccountTransactionLog>>(logService.getTransactionLogForAccount(accountNumber),HttpStatus.OK);
	}
	@PostMapping(path="transactionlog",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransactionLog>> addUser(@RequestBody TransactionLogRequest request){
		
		LocalDateTime fromDate = request.getFromDate().atStartOfDay();
		LocalDateTime toDate = request.getToDate().atTime(23, 59);
		return new ResponseEntity<List<AccountTransactionLog>>(logService.getTransactionLogByDate(fromDate, toDate),HttpStatus.CREATED);
		 
	}
}
