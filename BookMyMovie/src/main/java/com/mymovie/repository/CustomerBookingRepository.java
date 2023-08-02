package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.CustomerBooking;

public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Long> {

}
