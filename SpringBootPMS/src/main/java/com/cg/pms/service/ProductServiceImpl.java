package com.cg.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pms.dao.ProductDao;
import com.cg.pms.entity.Product;
import com.cg.pms.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public Product findProductById(int productId) throws ProductException {
		Optional<Product> optional=productDao.findById(productId);
		Product product=null;
		if(optional.isPresent())
		{
			product=optional.get();
		}
		else
		{
			throw new ProductException(productId+"Id Not Found");
		}
		
		return product;
	}

	@Override
	public Product createProduct(Product product) throws ProductException {
		productDao.saveAndFlush(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		if(productDao.existsById(product.getProductId()))
		{
			productDao.saveAndFlush(product);
		}
		else
		{
			throw new ProductException(product.getProductId()+" Not Found");
		}
		
		return product;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		
		Optional<Product> optional = productDao.findById(productId);
		Product product = null;
		if(optional.isPresent())
		{
			product = optional.get();
			productDao.deleteById(productId);
		}
		else
		{
			throw new ProductException(product.getProductId()+" Not Found");
		}
		
		return product;
	}

	@Override
	public List<Product> listAllProducts() throws ProductException {
		
		List<Product> list = productDao.findAll();
		
		if(list.isEmpty())
		{
			throw new ProductException("Empty Record");
		}
		
		return list;
	}

}
