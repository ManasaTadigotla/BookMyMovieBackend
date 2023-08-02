package com.mymovie.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.repository.TicketRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class TicketController {
	@Autowired
	private TicketRepository ticketRepo;

	/*
	@GetMapping("ticket/price/{type}")
	public BigDecimal getPriceByType(@PathVariable String type){
		return ticketRepo.findById(type).get().getPrice();		
	}
	*/
	@GetMapping("ticket/price/{type}")
	public BigDecimal getPriceByType(@PathVariable String type){
		return ticketRepo.getTicketByType(type).getPrice();
		
	}
}
