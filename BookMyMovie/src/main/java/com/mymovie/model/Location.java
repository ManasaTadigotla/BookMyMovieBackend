package com.mymovie.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locId;
	private String name;
	

	@OneToMany(mappedBy = "location")
	@JsonIgnore
	private List<Theatre> theatres=new ArrayList<>();
	
	
	public Long getLocId() {
		return locId;
	}
	public void setLocId(Long locId) {
		this.locId = locId;
	}
	public List<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addTheatre(Theatre theatre) {
		this.theatres.add(theatre);
		theatre.setLocation(this);
		
	}
	
}
