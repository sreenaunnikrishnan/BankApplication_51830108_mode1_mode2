package com.bankapp.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address_table")
public class Address {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String addressLine1;
	private String street;
	private String city;
	private String state;
	private String postalcode;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId_fk")
	private Customer customer;
	
	public Address() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public Address(String addressLine1, String street, String city, String state, String postalcode) {
		
		this.addressLine1 = addressLine1;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", postalcode=" + postalcode + "]";
	}
	
	

}
