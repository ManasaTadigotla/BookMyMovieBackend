package com.mymovie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private int duration;
	private String	hero;
	private String Heroine;
	private String director;
	private String imageLink;
	private Date releaseDate;
	private String[] showTimings;
	
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Lang_Movie",joinColumns = @JoinColumn(name="LangId"),
	inverseJoinColumns = @JoinColumn(name="movieId"))	
	private List<Language> Languages=new ArrayList<>();
	
	
	@JsonBackReference(value="movieGenreRef")
	@ManyToMany(mappedBy = "movies",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Genre> genres=new ArrayList<>();
	
	
	@JsonManagedReference(value="movieReference")	
	@OneToMany(mappedBy = "movie",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)	
	private List<Theatre> theatres=new ArrayList<>();	
	
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
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHeroine() {
		return Heroine;
	}
	public void setHeroine(String heroine) {
		Heroine = heroine;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String[] getShowTimings() {
		return showTimings;
	}
	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	
	public List<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/*
	public String getMovieLang() {
		return movieLang;
	}
	public void setMovieLang(String movieLang) {
		this.movieLang = movieLang;
	}
	*/
	public List<Language> getLanguages() {
		return Languages;
	}
	public void setLanguages(List<Language> languages) {
		Languages = languages;
	}
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
