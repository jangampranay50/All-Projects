package com.cg.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demo.entity.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
	
	
}
