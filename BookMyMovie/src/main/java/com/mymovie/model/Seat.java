package com.mymovie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String seatType;
	private String seatNumber;

	private boolean isBooked=false;
	//@JsonManagedReference(value="theatreReference")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="theatreId")
	private Theatre seatTheatre;
	
	//@JsonBackReference(value="showReference")
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="showId")
	private ShowTimes showTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeatType() {
		return seatType;
	}
	
	public ShowTimes getShowTime() {
		return showTime;
	}
	public void setShowTime(ShowTimes showTime) {
		this.showTime = showTime;
	}
	
	public Theatre getSeatTheatre() {
		return seatTheatre;
	}
	public void setSeatTheatre(Theatre seatTheatre) {
		this.seatTheatre = seatTheatre;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
