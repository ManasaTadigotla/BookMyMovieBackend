package com.mymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovie.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
