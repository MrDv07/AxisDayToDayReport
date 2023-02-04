package com.axis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;





@Document(collection = "product")
public class Product {
	
	
	@Id
	private int id;
	private String name;
	private String description;
	private int price ;
	private String category;
	
	
	public Product() {
		super();
	}


	public Product(int id, String name, String description, int price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
}
