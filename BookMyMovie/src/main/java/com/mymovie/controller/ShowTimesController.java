package com.mymovie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.model.Seat;
import com.mymovie.model.ShowTimes;
import com.mymovie.repository.SeatRepository;
import com.mymovie.repository.ShowTimesRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class ShowTimesController {
	@Autowired
	private ShowTimesRepository showTimeRepository;
	@Autowired
	private SeatRepository seatRepository;

	@GetMapping("/shows/{theatreId}")
	public List<ShowTimes> getShowsByTheatre(@PathVariable Long theatreId)
	{
		return showTimeRepository.findAll().stream()
				.filter(show->show.getTheatreShow().getId()==theatreId).collect(Collectors.toList());
	}
	
	@GetMapping("seats/{theatreId}/show/{showId}")
	public List<Seat> getSeatInfoByShow(@PathVariable Long theatreId,@PathVariable Long showId)
	{
		//return showTimeRepository.findAll().stream().filter(null)
			return seatRepository.findAll().stream()
					.filter(seat->seat.getSeatTheatre().getId()==theatreId).collect(Collectors.toList()).stream()
					.filter(s->s.getShowTime().getId()==showId).collect(Collectors.toList());
	}
}
