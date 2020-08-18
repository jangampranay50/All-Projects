package com.cg.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "product_tbl")
@DynamicUpdate
public class Product {
	
	@Id
	@Column(name = "product_id")
	@SequenceGenerator(name="mygen",sequenceName = "product_seq",allocationSize = 1)
	@GeneratedValue(generator = "mygen",strategy=GenerationType.SEQUENCE)
	private int productId;
	
	@Column(name = "product_name",length=15)
	private String productName;
	
	@Column(name = "product_price")
	private double price;

	public Product() {
		super();
	}

	public Product(int productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}