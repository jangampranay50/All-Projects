package com.cg.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("student/getchoolname")
	public ResponseEntity<String> getSchoolName()
	{
		ResponseEntity<String> re = restTemplate.getForEntity("http://school-service/school/getname", String.class);
		return re;
	}
	
	@GetMapping("student/validate/{user}/{pass}")
	public ResponseEntity<String> validate(@PathVariable("user") String user, @PathVariable("pass") String pass)
	{
		String url = "http://product.service/login/validate/"+user+"/"+pass;
		ResponseEntity<String> re = restTemplate.getForEntity(url,  String.class);
		return re;
	}
	
}
