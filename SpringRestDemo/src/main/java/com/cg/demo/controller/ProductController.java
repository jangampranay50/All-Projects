package com.cg.demo.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entity.Product;

@RestController
public class ProductController {

	@RequestMapping(value="product/{id}/{name}/{price}", method=RequestMethod.GET)
	public String sayHelloGet(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("price") double price)
	{
		return "welcome using GET METHOD ID : "+id+", Product Name : "+name+", Price : "+price;
	}
	
	@PostMapping("product")
	public String sayHelloPost(@RequestBody Product product)
	{
		return "Welcome using POST METHOD ID : "+ product.getProductId()+" Name : "+ product.getProductName()+" Price : "+ product.getPrice();
	}
	
	@GetMapping("product")
	public List<Product> getProductList()
	{
		Product p1 = new Product(1001,"Laptop",80000);
		Product p2 = new Product(1002,"Watch",30000);
		Product p3 = new Product(1003,"TV",20000);
		List<Product> list = Arrays.asList(p1,p2,p3);
		
		return list;
	}
	
	@DeleteMapping("product/{pid}")
	public Product sayHelloDelete(@PathVariable("id") int id)
	{
		Product product = new Product(id,"Laptop",30000);
		return product;
	}
	
}
