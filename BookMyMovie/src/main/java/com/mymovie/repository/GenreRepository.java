package com.mymovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;

import com.mymovie.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	@Query("select g from Genre g where g.name like?1")
	public List<Genre> getAllGenresByName(String genreName);
}
