package com.mymovie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.model.CustomerBooking;
import com.mymovie.repository.CustomerBookingRepository;

@RestController
public class CustomerBookingController {

	@Autowired
	private CustomerBookingRepository bookingRepository;
	
	@GetMapping("/customerbookings")
	public List<CustomerBooking> getCustomerbBookings()
	{
		return bookingRepository.findAll();
	}
	
	@GetMapping("/customerbookings/{id}")
	public Optional<CustomerBooking> getcuBooking(@PathVariable Long id)
	{
		return bookingRepository.findById(id);
	}
	
	@PostMapping("/customerbooking/add")
	public CustomerBooking addBooking(CustomerBooking booking)
	{
		return bookingRepository.save(booking);
	}
}
