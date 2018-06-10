package com.product.productinfo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long p_id;
	
	@Column(nullable = false)
	private String productname;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private double price;
	
	 @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name = "cat_id",nullable= false)
	
	private Category category;
		
	
	public Product( String productname, String type, double price) {
		super();
		
		this.productname = productname;
		this.type = type;
		this.price = price;
		this.category = category;
	}


	public Product() {
		super();
	}
	
		
	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Long getP_id() {
		return p_id;
	}


	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}
	

}
