package com.mymovie.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ShowTimes {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String time;

	@ManyToOne
	@JoinColumn(name="theatreId")
	@JsonIgnore
	private Theatre theatreShow;
	
	
	//@JsonManagedReference(value="showReference")
	@OneToMany(mappedBy = "showTime",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Seat> seatsInformation=new ArrayList<>() ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Theatre getTheatreShow() {
		return theatreShow;
	}

	public void setTheatreShow(Theatre theatreShow) {
		this.theatreShow = theatreShow;
	}

	public List<Seat> getSeatsInformation() {
		return seatsInformation;
	}

	public void setSeatsInformation(List<Seat> seatsInformation) {
		this.seatsInformation = seatsInformation;
	}
	

		public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public ShowTimes() {
		super();
		// TODO Auto-generated constructor stub
	}

}
