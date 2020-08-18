package com.cg.pms.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pms.entity.Product;
import com.cg.pms.exception.ErrorInfo;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("product/{pid}")
	public ResponseEntity<Product> findProductById(@PathVariable("pid") int productId) throws ProductException 
	{
		Product product=null;
	
		product=productService.findProductById(productId);
		
		ResponseEntity<Product> re = new ResponseEntity(product,HttpStatus.OK);

		return re;
	}
	
	@PostMapping("product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException
	{
		Product p = productService.createProduct(product);
		ResponseEntity<Product> re = new ResponseEntity(product,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException
	{
		Product p = productService.updateProduct(product);
		ResponseEntity<Product> re = new ResponseEntity(product,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("product/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("pid") int pid) throws ProductException
	{
		Product p = productService.deleteProductById(pid);
		ResponseEntity<Product> re = new ResponseEntity(p,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("product")
	public ResponseEntity<List<Product>> findAllProducts() throws ProductException
	{
		List<Product> list = productService.listAllProducts();
		ResponseEntity<List<Product>> re = new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return re;
	}
	
}
