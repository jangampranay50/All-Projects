package com.cg.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pms.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
