package com.cg.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.demo.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Product findProductById(int productId) {
		Product product = entityManager.find(Product.class, productId);
		return product;
	}

}
