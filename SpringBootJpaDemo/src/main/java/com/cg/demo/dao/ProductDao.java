package com.cg.demo.dao;

import com.cg.demo.entity.Product;

public interface ProductDao {
	
	public Product findProductById(int productId);
}
