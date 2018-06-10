package com.product.productinfo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long categoryid;
	
	@NotBlank
	@Column(nullable=false)
	private String categoryname;
	
	@NotBlank
	@Column(nullable=false)
	private String description;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="category",fetch=FetchType.EAGER)
	private Set<Product> products= new HashSet<>();

	public Category() {
		super();
	}

	public Category(@NotBlank String categoryname, @NotBlank String description) {
		super();
		this.categoryname = categoryname;
		this.description = description;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
	

}
