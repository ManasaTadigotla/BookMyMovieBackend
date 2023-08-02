package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.ShowTimes;

public interface ShowTimesRepository extends JpaRepository<ShowTimes, Integer>{

}
