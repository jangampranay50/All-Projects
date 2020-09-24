package com.cg.omms;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.omms.entity.Movie;
import com.cg.omms.exception.MovieException;
import com.cg.omms.service.MovieService;

@SpringBootTest
class OnlineMovieManagementSystemApplicationTests {

	@Autowired
	MovieService movieService;
	
	@Test
	public void testSearchMovie() throws MovieException 
	{
		List<Movie> list = movieService.listAllMovies("historical");
		Assertions.assertFalse(list.isEmpty());
	}
	
	@Test
	public void testSearchMovieErrorCase() throws MovieException
	{
		Assertions.assertThrows(MovieException.class, ()->movieService.listAllMovies("comedy"));
	}
	
	@Test
	public void testListAllMovies() throws MovieException
	{
		List<Movie> list = movieService.listAllMovies();
		Assertions.assertFalse(list.isEmpty());
	}
	
	@Test
	public void testFindMovieById() throws MovieException
	{
		movieService.findMovieById(1011);
	}
	
	@Test
	public void testFindMovieByDiffId() throws MovieException
	{
		Assertions.assertThrows(MovieException.class, ()->movieService.findMovieById(1000));
	}

}
