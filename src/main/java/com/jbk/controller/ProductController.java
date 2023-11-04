package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceimpl.ProductServiceImpl;

@RestController
public class ProductController {
	
	//ProductServiceImpl productServiceImpl=new ProductServiceImpl();
	//  ProductService service=new ProductServiceImpl();
	    
	    @Autowired
	    private ProductService service;
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody Product product) {
		//user want to add product data into list
		//in our case list database
		
		int status= service.addProduct(product);
		if(status==1){
		return "Data Added";
		}else {
			return "data not added";
		}
	}
	
	@GetMapping("/getProduct/{pid}")
	public Object getProductById(@PathVariable("pid") long id) {
		
		 Product product = service.getProductById(id);  //alt+shift+L it will complete left side
		 
		if(product !=null) {
			return product;
		}else {
			return "Product not found";
		}
	}
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam long productId) {
		//String msg=service.deleteProduct(productId);
		//return msg;
		return service.deleteProduct(productId);
	}
	
     @GetMapping("/get-all-product")
     public Object getAllProducts(){
    	 return service.getAllProducts();
     }
     
     @GetMapping("get-product-by-name/{name}")
     public Object getProductByName(@PathVariable("name") String productName) {
    	 
    	Product product= service.getProductByName(productName);
    	if(product !=null) {
			return product;
		}else {
			return "Product not found";
		}
     }
     
     @PutMapping("update-product")
     public String updateProduct(@RequestBody Product product) {
    	return service.updateProduct(product);
     }
}
