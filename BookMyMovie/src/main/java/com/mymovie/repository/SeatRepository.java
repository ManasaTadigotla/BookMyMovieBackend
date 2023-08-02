package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
