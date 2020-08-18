package com.cg.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.demo.bean.Airtel;
import com.cg.demo.bean.Mobile;

@Configuration
public class MobileBeanConfiguration 
{
	@Bean
	public Airtel getAirtel()
	{
		Airtel airtel = new Airtel();
		return airtel;
	}
	
	@Bean
	public Mobile getMobile()
	{
		Mobile mobile = new Mobile();
		mobile.setSimCard(getAirtel());
		return mobile;
	}
}
