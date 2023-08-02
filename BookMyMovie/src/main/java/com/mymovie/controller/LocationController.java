package com.mymovie.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.medicare.emedicines.model.Category;
//import com.medicare.emedicines.model.Product;
import com.mymovie.model.Location;
import com.mymovie.model.Theatre;
import com.mymovie.repository.LocationRepository;
import com.mymovie.repository.TheatreRepository;

//import com.medicare.emedicines.model.Category;
//import com.medicare.emedicines.model.Product;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class LocationController {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	TheatreRepository theatreRepository;
	
	//Retrieves available Locations
	@GetMapping("/locations")
	public List<Location> getAllLocations()
	{
		return locationRepository.findAll();
	}
	
	@GetMapping("/locations/{id}")
	public Optional<Location> getLocationById(@PathVariable Long id)
	{
		return locationRepository.findById(id);
	}
	
	
	
	//Retrieves the theatre list based on the given location
	@GetMapping("/Theatresbylocation/{locationId}")
	public List<Theatre> getTheatresByLocation(@PathVariable Long locationId)
	{
		if(locationRepository.existsById(locationId))
		{
			return locationRepository.findById(locationId).get().getTheatres();
		}
		else 
		{
			throw new NoSuchElementException("No location exist with given id");
		}
	}
	
	
	//Adds new location to location table
	@PostMapping("/location/add")
	public Location addLocation(@RequestBody Location location)
	{
		return locationRepository.save(location);
	}
	
	
	//Saves the Updated location details 
	@PutMapping("/location/update")
	public int updateLocation(@RequestBody Location location)
	{
	
		if(locationRepository.findById(location.getLocId())!=null)
		{
			locationRepository.save(location);
			return 1 ;
		}
		else
			return -1;
	}
	
	//checks whether location exists with the id provided.Deletes that record and return 1 else -1
	@DeleteMapping("/location/delete/{id}")
	public int deleteLocation(@PathVariable Long id)
	{
		if(locationRepository.findById(id) != null)
		{
		
			locationRepository.deleteById(id);
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	@PostMapping("/location/addtheatre/{locationId}")
	public Theatre addTheatreToLocation(@PathVariable Long locationId,@RequestBody Theatre theatre)
	{		
		Location location=locationRepository.findById(locationId).get();
		location.addTheatre(theatre);
		locationRepository.save(location);
		return theatreRepository.save(theatre);		
		//return product;		
	}
	

}
