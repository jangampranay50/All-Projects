package com.cg.omms.service;

import java.util.List;

import com.cg.omms.dto.MovieDto;
import com.cg.omms.entity.Movie;
import com.cg.omms.exception.MovieException;

//movie service interface
public interface MovieService {

	public Movie findMovieById(int movieId) throws MovieException;
	public Movie addMovie(MovieDto movieDto) throws MovieException;
	public Movie updateMovie(MovieDto movieDto) throws MovieException;
	public Movie deleteMovieById(int movieId) throws MovieException;
	public List<Movie> listAllMovies() throws MovieException;
	public List<Movie> listAllMovies(String genreName) throws MovieException;
	
}
