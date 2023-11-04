package com.jbk.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
//ProductDao dao=new ProductDaoImpl;
public class ProductDaoImpl implements ProductDao{
	
	List<Product> list =new ArrayList<>();
	
	
	
	public ProductDaoImpl() {
		list.add(new Product(101, "pen", 1, 1, 100, 10));
		list.add(new Product(102, "pencil", 2, 2, 200, 20));
		list.add(new Product(103, "book", 3, 3, 300, 30));
		
		System.out.println("in product dao impl");
	}

	@Override
	public int addProduct(Product product) {
	Product prdById=	getProductById(product.getProductId());
	Product prdByName= getProductByNmae(product.getProductName());
	if ( prdById==null && prdByName == null) {
		list.add(product);
		return 1;
	}else {
		return 2;
	} 
		
		
	}

	@Override
	public Product getProductById(long id) {
		
		for (Product product : list) {
			if(product.getProductId()==id) {
				
				return product;
			}
		}
		return null;
	}

	@Override
	public String deleteProduct(long productId) { 
		String msg="Empty List";
		for (Product product : list) {
			if(product.getProductId()== productId) {
				list.remove(product);
				msg="Product Removed";
			}else {
				msg= "Product not found to Delete";
			}
		}
		return msg;
		
		}
		


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Product getProductByNmae(String productName) {
		
		for (Product product : list) {
			if(product.getProductName().equals(productName)) {
				
				return product;
			}
		}
		
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		for (Product listproduct : list) {
			if(listproduct.getProductId()==product.getProductId()) {
				list.set(list.indexOf(listproduct), product);
				break;
			}
		}
		return "Updated";
	}


	

	

}
