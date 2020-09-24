package com.cg.omms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.omms.entity.Genre;

//genre dao interface extends jpa repository
@Repository
public interface GenreDao extends JpaRepository<Genre,Integer>{

}
