package com.mymovie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.model.Location;
import com.mymovie.model.Movie;
import com.mymovie.model.Seat;
import com.mymovie.model.ShowTimes;
import com.mymovie.model.Theatre;
import com.mymovie.repository.LocationRepository;
import com.mymovie.repository.SeatRepository;
import com.mymovie.repository.TheatreRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class TheatreController {
	
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/theatres")
	public List<Theatre> getAllTheatres()
	{
		return theatreRepo.findAll();
				
	}
	
	@GetMapping("/theatres/{locationId}")
	public List<Theatre> getAllTheatreByLocation(@PathVariable Long loctionId)
	{
		return theatreRepo.findAll().stream()
				.filter(t->t.getLocation().getLocId()==loctionId).collect(Collectors.toList());
	}	
	@GetMapping("/theatres/{locationId}/{movieId}")
	public List<Theatre> getAllTheatreByMovie(@PathVariable Long movieId,@PathVariable Long locationId)
	{
		return getAllTheatreByLocation(locationId).stream()
				.filter(t->t.getMovie().getId()==movieId).collect(Collectors.toList());
	}
	
	@GetMapping("/moviesbylocation/{locationId}")
	public List<Movie> getMoviesByLocation(@PathVariable Long locationId)
	{
		List<Movie> movies=new ArrayList<>();
		List<Theatre> theatres=theatreRepo.findAll().stream()
				.filter(t->t.getLocation().getLocId()==locationId).collect(Collectors.toList());
		for(Theatre t:theatres)
		{
			if(!movies.contains(t.getMovie()))
			{
			movies.add(t.getMovie());
			}
		}
		return movies;
		//return movieRepository.findAll().stream().filter(movie->movie.gett)
		//theatreRepo.findAll().stream().filter(t->t.getLocation().getLocId()==locationId
	}
	@GetMapping("/theatre/shows/{theatreId}")
	public List<ShowTimes> getShowTimes(@PathVariable Long theatreId)
	{
		//return theatreRepo.findById(theatreId).get().getShows();
			return null;	
	}	
	
	
	@GetMapping("/theatre/{id}")
	public Theatre getTheatreById(@PathVariable Long id)
	{		
		return theatreRepo.findById(id).get();		
	}
	@PostMapping("/theatre/add")
	public Theatre addNewTheatre(@RequestBody Theatre theatre)
	{		
		//String[] shows={"10:30","1:00","3:30","6:30"};
		//theatre.setShowTimings(shows);
		return theatreRepo.save(theatre);		
	}
	@PutMapping("/theatre/update")
	public Theatre updateTheatre(@RequestBody Theatre theatre)
	{
		if(theatreRepo.existsById(theatre.getId()))
		{
			return theatreRepo.save(theatre);
		}
		else
		{
			return null;
		}		
	}	
	@DeleteMapping("/theatre/delete/{id}")
	public int deletetheatre(@PathVariable Long id)
	{
		if(theatreRepo.existsById(id))
		{
			theatreRepo.deleteById(id);
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	@GetMapping("/theatre/seats/{theatreId}")
	public List<Seat> getSeatsInfo(@PathVariable Long theatreId)
	{
		return theatreRepo.findById(theatreId).get().getSeatsInfo();
		//return seatRepo.findAll()
				//.stream().
				//filter(seat->theatreId==seat.getSeatTheatre().getId()).collect(Collectors.toList());
		
	}
	
}
