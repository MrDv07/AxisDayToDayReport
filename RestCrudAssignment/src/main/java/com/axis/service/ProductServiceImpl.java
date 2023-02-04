package com.axis.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.axis.entity.Product;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidNameException;
import com.axis.exception.InValidPriceException;
import com.axis.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService  {

	@Autowired 
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product  product) {
		
		if(product.getName() == "" ) {
			throw new InValidNameException("Name Cannot be Blank");
		}
		else if(product.getPrice()<100) {
			throw new InValidPriceException("Invalid Price, Minimum Price Cannot be less than 100");
		}
		
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		
		Optional<Product> emp = productRepository.findById(id);
		
		
		if(emp.isPresent())
			return emp.get();
			else
			throw new IdNotFoundException("There is no product by this Id");
	}

	@Override
	public Product updateProductById(int id, Product product) {
		
	Optional<Product> emp = productRepository.findById(id);
	if(emp.isPresent())
	return productRepository.save(product);
	else
	throw new IdNotFoundException("No Product by this id present to Update");
	}

	@Override
	public String deleteProductById(int id) {
		
	Optional<Product>emp = productRepository.findById(id);
	if(emp.isPresent()){
	productRepository.deleteById(id);
	return "employee deleted";
	}
	else
	throw new IdNotFoundException("No product by this Id present to Delete");
	}
	
}
