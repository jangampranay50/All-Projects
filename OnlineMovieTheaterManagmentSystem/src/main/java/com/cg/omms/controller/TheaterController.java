package com.cg.omms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omms.entity.Theater;
import com.cg.omms.exception.TheaterException;
import com.cg.omms.service.TheaterService;
import com.cg.omms.util.TheaterConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	

	
	
	
	@GetMapping(TheaterConstants.VIEW_ALL_THEATER_URL)
	public List<Theater>  listAllTheaters() throws TheaterException
	{
	  
		List<Theater> list = theaterService.listAllTheaters();
		
		return list;
		
	}
	
	@GetMapping(TheaterConstants.VIEW_BY_THEATER_ID)
	public  Theater  findTheaterById(@PathVariable("id") int theaterId) throws TheaterException 
	{
		
		Theater  theater = theaterService.findTheaterById(theaterId);
		
		
		return theater;
	}
	
	@GetMapping(TheaterConstants.VIEW_THEATER_BY_MOVIE_ID)
	public  List  findTheaterByMovieId(@PathVariable("mid") int movieId) throws TheaterException 
	{
		
		List<Theater> list = theaterService.listAllTheaters(movieId);
		
		
		return list;
	}
	/*
	 * @DeleteMapping("theater/{id}") public ResponseEntity<Theater>
	 * deleteTheaterById(@PathVariable("id") int theaterId) throws Exception {
	 * 
	 * Theater theater = theaterService.findTheaterById(theaterId);
	 * ResponseEntity<Theater> rt = null;
	 * 
	 * if(theater!=null) { theater = theaterService.deleteTheaterById(theaterId);
	 * rt= new ResponseEntity<Theater>(theater,HttpStatus.OK); } else { rt=new
	 * ResponseEntity<Theater>(HttpStatus.NOT_FOUND); } return rt; }
	 * 
	 * @PostMapping("employee") public ResponseEntity<Theater>
	 * addtheater(@RequestBody Theater theater) { Theater theater2 =
	 * theaterService.addTheater(theater); ResponseEntity<Theater> rt= new
	 * ResponseEntity<Theater>(theater,HttpStatus.OK); return rt; }
	 */
	
}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

