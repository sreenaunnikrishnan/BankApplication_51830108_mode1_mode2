package com.bankapp.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer_table")
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	
	private String name;
	private String email;
	private String phone;
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval=true)
	private Address address;
	
	@OneToOne
	@JoinColumn(name="accountNumber_fk")
	@JsonIgnore
	private Account account;
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer() {
		
	}
	public Customer(String name, String email, String phone, Address address) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		address.setCustomer(this);
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	

}
