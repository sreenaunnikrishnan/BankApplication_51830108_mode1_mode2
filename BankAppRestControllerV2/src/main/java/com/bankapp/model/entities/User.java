package com.bankapp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user_table")
public class User {

	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	
	private String name;
	
	@JsonIgnore
	private String password;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String[] roles;
	
	private String phone;
	

	
	private boolean isActive;

	public User() {
	}

	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public static void setEncoder(BCryptPasswordEncoder encoder) {
		User.encoder = encoder;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password=encoder.encode(password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User(String name, String password, String email, String[] roles, String phone,
			boolean isActive) {

		this.name = name;
		setPassword(password);
		this.email = email;
		this.roles = roles;
		this.phone = phone;
	
		this.isActive = isActive;
	}

}
