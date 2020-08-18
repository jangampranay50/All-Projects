package com.cg.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.ProductDao;
import com.cg.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public Product findProductById(int productId) {
		Product product = productDao.findProductById(productId);
		
		return product;
	}

}
