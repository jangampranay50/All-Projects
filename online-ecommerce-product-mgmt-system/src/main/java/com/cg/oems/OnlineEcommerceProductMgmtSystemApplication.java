package com.cg.oems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineEcommerceProductMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEcommerceProductMgmtSystemApplication.class, args);
	}

}
