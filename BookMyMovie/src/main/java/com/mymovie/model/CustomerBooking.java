package com.mymovie.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class CustomerBooking {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private Date bookingDate;
	private int numberOfSeats;
	private String[] seatNumbers;
	/*
	@ManyToOne
	@JoinColumn(name="movieId",insertable = false,nullable = false)
	private Movie bookedMovie;	
	*/
	@OneToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	/*
	@ManyToOne
	@JoinColumn(name="theatreId")
	private Theatre theatre;
	*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}/*
	public Movie getBookedMovie() {
		return bookedMovie;
	}
	public void setBookedMovie(Movie bookedMovie) {
		this.bookedMovie = bookedMovie;
	}
	*/
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	/*
	public User getBookingcustomer() {
		return user;
	}
	public void setBookingcustomer(User user) {
		this.user = user;
	}
	*/
	/*
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}	
	*/
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String[] getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(String[] seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	/*
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/
	//Constructor
	public CustomerBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
