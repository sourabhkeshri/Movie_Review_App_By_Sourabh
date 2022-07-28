package com.sourabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourabh.model.Movie;
import com.sourabh.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		
		return movieRepository.findAll();
	}

	@Override
	public void saveMovie(Movie movie) {
		this.movieRepository.save(movie);
		
	}

	@Override
	public Movie getMovieById(long id) {
		return this.movieRepository.getById(id);
	}

	@Override
	public void deleteMovieById(long id) {
		this.movieRepository.deleteById(id);
		
	}


}
