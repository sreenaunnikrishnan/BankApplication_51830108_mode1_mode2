package com.bankapp.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bankapp.model.service.exceptions.AccountBlockedException;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;
import com.bankapp.model.service.exceptions.UserNotFoundException;
import com.bankapp.web.controller.bean.CustomErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(AccountNotFoundException.class)
	 public ResponseEntity<CustomErrorResponse> handleAccountNotFoundEx(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }


	@ExceptionHandler(NotSufficientFundException.class)
	 public ResponseEntity<CustomErrorResponse> handleNotSufficientFundEx(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }
	
	@ExceptionHandler(CustomerNotFoundException.class)
	 public ResponseEntity<CustomErrorResponse> handleCustomerNotFoundEx(Exception ex) {

       CustomErrorResponse errors = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());

       return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

   }
	
	@ExceptionHandler(AccountBlockedException.class)
	 public ResponseEntity<CustomErrorResponse> handleAccountBlockedEx(Exception ex) {

      CustomErrorResponse errors = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());

      return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

  }
	@ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<CustomErrorResponse> handleUserNotFoundEx(Exception ex) {

     CustomErrorResponse errors = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());

     return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

 }

}
