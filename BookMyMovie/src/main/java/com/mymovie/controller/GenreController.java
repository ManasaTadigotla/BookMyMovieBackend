package com.mymovie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.model.Genre;
import com.mymovie.model.Movie;
import com.mymovie.repository.GenreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
//@RequestMapping("/genres")
public class GenreController {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping("/genres")
	public List<Genre> getAllGenres()
	{
		return genreRepository.findAll();
	}
	
	@GetMapping("/genres/{id}")
	public Optional<Genre> getGenreById(@PathVariable Long id)
	{
		return genreRepository.findById(id);		
	}
	
	@GetMapping("genre/movies/{genreId}")
	public List<Movie> getMoviesByGenre(@PathVariable Long genreId)
	{
		return genreRepository.findById(genreId).get().getMovies();
		
	}
	
	@PostMapping("genre/add")
	public Genre addGenre(@RequestBody Genre genre)
	{
		return genreRepository.save(genre);
	}
	
	//Returns 1 ,if genre with given id exists.
	//else returns -1.
	@PutMapping("genre/update")
	public int updateGenre(@RequestBody Genre genre)
	{
		if(genreRepository.existsById(genre.getId()))
		{
			 genreRepository.save(genre);
			 return 1;
		}
		else
		{
			return -1;
		}
	}	
	@DeleteMapping("genre/delete/{id}")
	public int deleteGenre(@PathVariable Long id)
	{	
		if(genreRepository.existsById(id))
		{
			genreRepository.deleteById(id);
			return 1;
		}
		else
		{
			return -1;
		}
	}

}
