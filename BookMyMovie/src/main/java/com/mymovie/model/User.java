package com.mymovie.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DiscriminatorFormula;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phone;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String location;
	private String userType;
	
	//Mappings
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<CustomerBooking> bookings=new ArrayList<>();	
	
	//Getters and Setters
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	public String getLastName() {
	return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getLocation() {
	return location;
	}
	public void setLocation(String location) {
	this.location = location;
	}
	public List<CustomerBooking> getBookings() {
	return bookings;
	}
	public void setBookings(List<CustomerBooking> bookings) {
	this.bookings = bookings;
	}
	public User() {
	super();
	// TODO Auto-generated constructor stub
	}
	
}
