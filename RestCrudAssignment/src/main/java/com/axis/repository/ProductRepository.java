package com.axis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.axis.entity.Product;



public interface ProductRepository extends MongoRepository<Product, Integer>{
	

}
