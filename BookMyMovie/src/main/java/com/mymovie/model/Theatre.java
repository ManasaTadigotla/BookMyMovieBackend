package com.mymovie.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;

@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int noOfSeats;
	private String[] showTimings= {"10:30","1:00","3:30","6:30"};
	
	@OneToMany(mappedBy = "theatreShow",fetch = FetchType.LAZY)

	private List<ShowTimes> shows=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "seatTheatre",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Seat> seatsInfo=new ArrayList<>();
    	 
	@Embedded
	private Address address;
	//@JsonBackReference(value = "theatreReference")
	@OneToMany(mappedBy = "theatre",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket> movieTickets;
	//Mappings
	/*
	@OneToMany(mappedBy = "theatre")
	private List<CustomerBooking> booking=new ArrayList<>();
	*/
	
	@ManyToOne
	@JoinColumn(name="theatreLocationId")
	
	private Location location;		
	
	@JsonBackReference(value="movieReference")
	@ManyToOne()
	@JoinColumn(name="fkmovieId")	
	@JsonIgnore
	private Movie movie;
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String[] getShowTimings() {
		return showTimings;
	}
	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}
	
	public List<Ticket> getMovieTickets() {
		return movieTickets;
	}
	public void setMovieTickets(List<Ticket> movieTickets) {
		this.movieTickets = movieTickets;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public List<Seat> getSeatsInfo() {
		return seatsInfo;
	}
	public void setSeatsInfo(List<Seat> seatsInfo) {
		this.seatsInfo = seatsInfo;
	}
	
	public List<ShowTimes> getShows() {
		return shows;
	}
	public void setShows(List<ShowTimes> shows) {
		this.shows = shows;
	}
	
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
