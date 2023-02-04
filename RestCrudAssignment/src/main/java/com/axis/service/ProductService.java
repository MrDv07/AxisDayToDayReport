package com.axis.service;

import java.util.List;

import com.axis.entity.Product;

public interface ProductService {

	
	Product addProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
	Product updateProductById(int id , Product product);
	String deleteProductById(int id );
	
}
