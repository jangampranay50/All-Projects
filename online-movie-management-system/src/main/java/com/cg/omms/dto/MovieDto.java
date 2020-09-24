package com.cg.omms.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//Movie Data Transfer Object class
public class MovieDto {

	//variables
	private int movieId;
	
	private String movieName;
	
	private String movieDirector;
	
	private String movieLength;
	
	private String languages;
	
	@DateTimeFormat(pattern="yyyy-M-d")
	private LocalDate releaseDate;
	
	private int genreId;

	//getters and setters
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
}
