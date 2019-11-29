package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.AccountTransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountTransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AccountTransactionLogRepository transactionLogRepo;

	@Override
	public User findByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

	@Override
	public User addUser(User user) {
		userRepo.save(user);
		return user;
		
	}

	@Override
	public List<User> findAll() {
	
		return userRepo.findAll();
	}

	@Override
	public void blockUser(Long userId) {
		User userToBeBlocked = findById(userId);
		userToBeBlocked.setActive(false);
		userRepo.save(userToBeBlocked);
		
	}

	@Override
	public void deleteUser(Long userId) {
		User userToBeDeleted = findById(userId);
		userRepo.delete(userToBeDeleted);
		
	}

	@Override
	public User updateUser(Long userId, User user) {
		User userToBeUpdated = findById(userId);
		userToBeUpdated.setEmail(user.getEmail());
		userToBeUpdated.setPhone(user.getPhone());
		userToBeUpdated.setRoles(user.getRoles());
		userRepo.save(userToBeUpdated);
		return userToBeUpdated;
	}

	@Override
	public User findById(Long id) {
		
		return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
}
