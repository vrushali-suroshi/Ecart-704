package com.jbk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbk.dao.ProductDao;
import com.jbk.daoimpl.ProductDaoImpl;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
 
	//ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	  
	 // ProductDao dao=new ProductDaoImpl();
	
	public ProductServiceImpl() {
		System.out.println("In product service impl");
	}
	
	@Autowired
	private ProductDao dao;
	
	

	@Override
	public int addProduct(Product product) {
		return dao.addProduct(product);
	}



	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return dao.getProductById(id);
	}



	@Override
	public String deleteProduct(long productId) {
		//String msg= dao.deleteProduct(productId);
		//return msg;
		return dao.deleteProduct(productId);
	}



	@Override
	public Object getAllProducts() {
		List<Product> list=dao.getAllProducts();
		
		if(!list.isEmpty()) {
			return list;
		}else {
			return "Empty List";
		}
		
	}
	@Override
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		return dao.getProductByNmae(productName);
	}



	@Override
	public String updateProduct(Product product) {
		Product listProduct=getProductById(product.getProductId());
		if(listProduct !=null) {
			return dao.updateProduct(product);
		}else {
			return "Product Not Found To Update";
		}
		
	}





	
	
}
