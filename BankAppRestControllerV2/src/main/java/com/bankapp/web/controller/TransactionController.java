package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.configuration.SecUser;
import com.bankapp.web.controller.bean.DepositWithdrawRequest;
import com.bankapp.web.controller.bean.DepositWithdrawResponse;
import com.bankapp.web.controller.bean.TransferRequest;
import com.bankapp.web.controller.bean.TransferResponse;

@RestController
@RequestMapping(path = "api")
public class TransactionController {
	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping(path = "transaction/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepositWithdrawResponse> depositInAnAccount(
			@RequestBody DepositWithdrawRequest request,@AuthenticationPrincipal SecUser user) {
		
		accountService.deposit(request.getAccountNumber(), request.getAmount());
		DepositWithdrawResponse response = new DepositWithdrawResponse(request.getAccountNumber(), request.getAmount(),"DEPOSIT", user.getUsername());
		return new ResponseEntity<DepositWithdrawResponse>(response,HttpStatus.OK);
	}

	@PostMapping(path = "transaction/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepositWithdrawResponse> withdrawInAnAccount(
			@RequestBody DepositWithdrawRequest request,@AuthenticationPrincipal SecUser user) {

		accountService
				.withdraw(request.getAccountNumber(), request.getAmount());
		DepositWithdrawResponse response = new DepositWithdrawResponse(request.getAccountNumber(), request.getAmount(),"DEPOSIT", user.getUsername());

		return new ResponseEntity<DepositWithdrawResponse>(response,HttpStatus.OK);
	}

	@PostMapping(path = "transaction/transfer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransferResponse> transferFromAccToAcc(
			@RequestBody TransferRequest request,@AuthenticationPrincipal SecUser user) {

		accountService.transfer(request.getFromAcc(), request.getToAcc(),
				request.getAmount());
		TransferResponse response = new TransferResponse(request.getFromAcc(),request.getToAcc(),"TRANSFER",request.getAmount(),user.getUsername());
		return new ResponseEntity<TransferResponse>(response,HttpStatus.OK);
	
	
	
}

}
