package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@RestController
@RequestMapping(path="api")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping(path="user",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping(path="user/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByEmail(@PathVariable(name="email") String email){

		return new ResponseEntity<User>(userService.findByEmail(email),HttpStatus.OK);
	}

	
	@DeleteMapping(path="user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUserById(@PathVariable(name="id")Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping(path="user",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
		 
	}
	
	@PutMapping(path="user/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<User> updateUserById(@PathVariable(name="id") long id,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(id, user),HttpStatus.OK);
		
	}
	
	@GetMapping(path="user/block/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> blockUser(@PathVariable(name="id") Long id){
		userService.blockUser(id);
		return new ResponseEntity<User>(HttpStatus.LOCKED);
	}


	
	

}
