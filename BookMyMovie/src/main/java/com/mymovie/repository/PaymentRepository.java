package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
