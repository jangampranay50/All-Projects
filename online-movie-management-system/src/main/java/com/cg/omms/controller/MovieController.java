package com.cg.omms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omms.dto.MovieDto;
import com.cg.omms.entity.Movie;
import com.cg.omms.exception.MovieException;
import com.cg.omms.service.MovieService;

//rest controller class
@RestController
public class MovieController {

	//autowired movie service interface
	@Autowired
	MovieService movieService;
	 
	//get mapping for searching a movie by its Id
	@GetMapping("searchmovie/{mid}")
	public ResponseEntity<Movie> findMovieById(@PathVariable("mid") int movieId) throws MovieException 
	{
		Movie movie = null;
	
		movie = movieService.findMovieById(movieId);
		
		ResponseEntity<Movie> re = new ResponseEntity<Movie>(movie,HttpStatus.OK);

		return re;
	}
	
	//post mapping for adding a movie 
	@PostMapping("addmovie")
	public ResponseEntity<Movie> addMovie(@RequestBody MovieDto movieDto) throws MovieException
	{
		Movie mv = movieService.addMovie(movieDto);
		ResponseEntity<Movie> re = new ResponseEntity<Movie>(mv,HttpStatus.OK);
		return re;
	}
	
	//put mapping for updating a movie
	@PutMapping("updatemovie")
	public ResponseEntity<Movie> updateMovie(@RequestBody MovieDto movieDto) throws MovieException
	{
		Movie mv = movieService.updateMovie(movieDto);
		ResponseEntity<Movie> re = new ResponseEntity<Movie>(mv,HttpStatus.OK);
		return re;
	}
	
	//delete mapping for deleting a movie by its Id
	@DeleteMapping("deletemovie/{mid}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable("mid") int mid) throws MovieException
	{
		Movie movie = movieService.deleteMovieById(mid);
		ResponseEntity<Movie> re = new ResponseEntity<Movie>(movie,HttpStatus.OK);
		return re;
	}
	
	//get mapping for listing all movies
	@GetMapping("allmovies")
	public ResponseEntity<List<Movie>> findAllMovies() throws MovieException
	{
		List<Movie> list = movieService.listAllMovies();
		ResponseEntity<List<Movie>> re = new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
		return re;
	}
	
	//get mapping for listing all movies by its genre name
	@GetMapping("searchmoviebygenre/{gName}")
	public ResponseEntity<List<Movie>> findAllMovies(@PathVariable("gName") String genreName) throws MovieException 
	{
		List<Movie> list = movieService.listAllMovies(genreName);
		ResponseEntity<List<Movie>> re = new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
		return re;
	}
	
}
