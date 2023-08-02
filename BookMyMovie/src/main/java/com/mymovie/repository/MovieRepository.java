package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
