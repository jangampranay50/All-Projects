package com.cg.omms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//genre entity class
@Entity
@Table(name="genre_tbl1")
public class Genre {

	//variables
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",sequenceName="genre_seq1",allocationSize=1)
	@Column(name="genre_id")
	private int genreId;
	
	@Column(name="genre_name")
	private String genreName;

	//getters and setters
	
	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
}
