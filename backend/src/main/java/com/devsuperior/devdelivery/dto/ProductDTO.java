package com.devsuperior.devdelivery.dto;

import java.io.Serializable;

import com.devsuperior.devdelivery.entities.Product;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	

	public ProductDTO() {
		
	}

	public ProductDTO(String name, Double price, String description, String imageUri) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}
	
	public ProductDTO(Product product) {
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		imageUri = product.getImageUri();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
}
