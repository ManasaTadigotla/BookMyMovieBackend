package com.mymovie.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mymovie.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {
	
	
	@Query("select t from Ticket t where t.type=?1")
	public Ticket getTicketByType(String type);

}
