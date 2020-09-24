package com.cg.omms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.omms.entity.Movie;

//movie dao interface extends jpa repository
@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>{

	@Query("from Movie m where m.movieGenre.genreName=:gName")
	public List<Movie> findMovieByGenre(@Param("gName")String genreName);
}
