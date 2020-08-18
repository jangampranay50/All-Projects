package com.cg.pms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pms.entity.Product;
import com.cg.pms.exception.ProductException;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Product findProductById(int productId) throws ProductException {
		Product product = entityManager.find(Product.class, productId);
		return product;
	}

	@Override
	public Product createProduct(Product product) throws ProductException {
		entityManager.persist(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		entityManager.merge(product);
		return product;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		Product product = entityManager.find(Product.class, productId);
		if(product!=null)
		{
			entityManager.remove(product);
		}
		return product;
	}

	@Override
	public List<Product> listAllProducts() throws ProductException {
		String qry = "SELECT p FROM Product p";
		TypedQuery<Product> query = entityManager.createQuery(qry,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> listPriceRange(double low,double high) throws ProductException {
		String qry = "SELECT p FROM Product p where price>=:low and price<=:high";
		TypedQuery<Product> query = entityManager.createQuery(qry,Product.class);
		
		List<Product> list = query.setParameter("low", low).setParameter("high", high).getResultList();
		
		return list;
	}

}
