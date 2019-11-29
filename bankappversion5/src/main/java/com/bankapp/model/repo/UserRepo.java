package com.bankapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public User findByEmail(String email);

}
