package com.cg.demo.service;

import java.util.Optional;

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
		Product product = null;
		
		Optional<Product> optional = productDao.findById(productId);
		
		if(optional.isPresent())
		{
			product = optional.get();
		}
		
		return product;
	}

}
