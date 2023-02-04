package com.axis.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axis.entity.Product;
import com.axis.service.ProductService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {

	
	@Autowired
    ProductService productService;
	
	
    @PostMapping("/product")
    ResponseEntity<Product> addProduct(@RequestBody Product product){
    return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
      }
    
   
     @GetMapping("/product")
     ResponseEntity<List<Product>> getAllProduct(){
     return new ResponseEntity<List<Product>>(productService.getAllProduct() , HttpStatus.OK);
     }


     @GetMapping("/product/{id}")
     ResponseEntity<Product> getProductById(@PathVariable int id){
     return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);}
    


    @PutMapping("/product/{id}")
    ResponseEntity<Product> updateProductById(@PathVariable int id,@RequestBody Product product){
    return new ResponseEntity<Product>(productService.updateProductById(id, product), HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/product/{id}")
    ResponseEntity<String> deleteProductById(@PathVariable int id){
    return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);
    
    }
    
    
    
	

}
