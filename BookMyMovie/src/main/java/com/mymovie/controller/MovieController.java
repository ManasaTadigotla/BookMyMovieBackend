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
import org.springframework.web.bind.annotation.RestController;

import com.mymovie.model.Language;
import com.mymovie.model.Movie;
import com.mymovie.model.Theatre;
import com.mymovie.repository.GenreRepository;
import com.mymovie.repository.LanguageRepository;
import com.mymovie.repository.MovieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private LanguageRepository languageRepository;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies()
	{
		return movieRepository.findAll();
	}
	
	@GetMapping("/movies/{id}")
	public Optional<Movie> getMovieById(@PathVariable Long id)
	{
		return movieRepository.findById(id);
	}
	
	@GetMapping("/moviesbygenre/{genreid}")
	public List<Movie> getMoviesByGenre(@PathVariable Long genreid)
	{
		return genreRepository.findById(genreid).get().getMovies();
	}
	
	
	
	
	@GetMapping("theatresbymovie/{movieId}")
	public List<Theatre> getTheatresByMovie(@PathVariable Long movieId)
	{
		return movieRepository.findById(movieId).get().getTheatres();
	}	
	
	@PostMapping("/movie/add")
	public Movie addMovie(@RequestBody Movie movie)
	{
		return movieRepository.save(movie);
	}
	@PutMapping("/movie/update")
	public Movie updateMovie(@RequestBody Movie movie)
	{
		if(movieRepository.existsById(movie.getId()))
		{
			return movieRepository.save(movie);
		}
		else
		{
			return null;
		}		
	}
	@DeleteMapping("/movie/delete/{id}")
	public int deleteMovie(@PathVariable Long id)
	{
		if(movieRepository.existsById(id))
		{
			movieRepository.deleteById(id);
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	//Movie language Apis
	@GetMapping("/languages")
	public List<Language> getAllLanguages()
	{
		return languageRepository.findAll();
	}
	
}
