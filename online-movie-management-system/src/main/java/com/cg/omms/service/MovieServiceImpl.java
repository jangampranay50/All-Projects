package com.cg.omms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omms.dao.GenreDao;
import com.cg.omms.dao.MovieDao;
import com.cg.omms.dto.MovieDto;
import com.cg.omms.entity.Genre;
import com.cg.omms.entity.Movie;
import com.cg.omms.exception.MovieException;
import com.cg.omms.util.MovieConstants;

//movie service implementation class implements movie service interface
@Service
public class MovieServiceImpl implements MovieService {

	//autowired movie dao interface
	@Autowired
	MovieDao movieDao;
	
	//autowired genre dao interface
	@Autowired
	GenreDao genreDao;
	
	Movie movie = new Movie();
	
	//overriding findMovieById(parameter type int movieId) from movie service interface - [method to search a movie by its Id]
	@Override
	public Movie findMovieById(int movieId) throws MovieException {
		Optional<Movie> optional = movieDao.findById(movieId);
		if(optional.isPresent())
		{
			movie = optional.get();
		}
		else
		{
			throw new MovieException(movieId+" "+MovieConstants.MOVIE_NOT_FOUND);
		}
		
		return movie;
	}

	//overriding addMovie(parameter type MovieDto) from movie service interface - [method to add movie]
	@Override
	public Movie addMovie(MovieDto movieDto) throws MovieException {
		Optional<Genre> optGenre = genreDao.findById(movieDto.getGenreId());
		if(!optGenre.isPresent())
		{
			throw new MovieException(MovieConstants.GENRE_NOT_FOUND);
		}
		movie.setMovieName(movieDto.getMovieName());
		movie.setMovieDirector(movieDto.getMovieDirector());
		movie.setMovieLength(movieDto.getMovieLength());
		movie.setLanguages(movieDto.getLanguages());
		movie.setReleaseDate(movieDto.getReleaseDate());
		Genre genre = optGenre.get();
		movie.setMovieGenre(genre);
		movieDao.saveAndFlush(movie);
		return movie;
	}

	//overriding updateMovie(parameter type MovieDto) from movie service interface - [method to update movie details]
	@Override
	public Movie updateMovie(MovieDto movieDto) throws MovieException {
		Optional<Movie> optMovie = movieDao.findById(movieDto.getMovieId());
		if(!optMovie.isPresent())
		{
			throw new MovieException(movieDto.getMovieId()+" "+MovieConstants.MOVIE_NOT_FOUND);
		}
		Optional<Genre> optGenre = genreDao.findById(movieDto.getGenreId());
		if(!optGenre.isPresent())
		{
			throw new MovieException(MovieConstants.GENRE_NOT_FOUND);
		}
		movie = optMovie.get();
		movie.setMovieId(movieDto.getMovieId());
		movie.setMovieName(movieDto.getMovieName());
		movie.setMovieDirector(movieDto.getMovieDirector());
		movie.setMovieLength(movieDto.getMovieLength());
		movie.setLanguages(movieDto.getLanguages());
		movie.setReleaseDate(movieDto.getReleaseDate());
		Genre genre = optGenre.get();
		movie.setMovieGenre(genre);
		movieDao.saveAndFlush(movie);
		return movie;
	}

	//overriding deleteMovieById(parameter type int movieId) from movie service interface -[method to delete a movie by its Id]
	@Override
	public Movie deleteMovieById(int movieId) throws MovieException {
		Optional<Movie> optional = movieDao.findById(movieId);
		
		if(optional.isPresent())
		{
			movie = optional.get();
			movieDao.deleteById(movieId);
		}
		else
		{
			throw new MovieException(movieId+" "+MovieConstants.MOVIE_NOT_FOUND);
		}
		
		return movie;
	}

	//overriding listAllMovies() from movie service interface {Method Overloading} - [method to get all movies]
	@Override
	public List<Movie> listAllMovies() throws MovieException {
		List<Movie> list = movieDao.findAll();
		
		if(list.isEmpty())
		{
			throw new MovieException(MovieConstants.EMPTY_RECORD);
		}
		
		return list;
	}

	//overriding listAllMovies(parameter type String genre name) from movie service interface {Method Overloading} - [method to search movies by genre name]
	@Override
	public List<Movie> listAllMovies(String genreName) throws MovieException {
		
		List<Movie> list = movieDao.findMovieByGenre(genreName.toUpperCase());
		if(list.isEmpty())
		{
			throw new MovieException(MovieConstants.EMPTY_RECORD);
		}
		list.sort((t1,t2)->t1.getMovieName().compareTo(t2.getMovieName()));
		return list;
	}
	
}
