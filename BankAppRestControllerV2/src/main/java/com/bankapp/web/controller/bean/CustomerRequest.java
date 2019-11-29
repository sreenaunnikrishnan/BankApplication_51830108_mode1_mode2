package com.bankapp.web.controller.bean;

public class CustomerRequest {
	private String name;
	private String email;
	private String phone;
	private String addressLine1;
	private String street;
	private String city;
	private String state;
	private String postalcode;
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
	public CustomerRequest(String name, String email, String phone, String addressLine1, String street, String city,
			String state, String postalcode) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
	}
	public CustomerRequest() {
		
	}

}
