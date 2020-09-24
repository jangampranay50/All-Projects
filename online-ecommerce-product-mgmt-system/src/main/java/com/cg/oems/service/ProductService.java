package com.cg.oems.service;

import java.util.List;

import com.cg.oems.entity.Product;
import com.cg.oems.exception.ProductException;

public interface ProductService {

	public Product findProductById(int productId) throws ProductException;
    
	public Product createProduct(Product product) throws ProductException;
	
	public Product updateProduct (Product product) throws ProductException;
	
	public Product deleteProductById(int productId) throws ProductException;
	
	public List<Product> listAllProducts()throws ProductException;
	
	public List<Product> listOfProducts(double low, double high);
	
}
