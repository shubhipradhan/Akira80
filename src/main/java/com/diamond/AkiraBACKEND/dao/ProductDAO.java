package com.diamond.AkiraBACKEND.dao;

import java.util.List;

import com.diamond.AkiraBACKEND.model.Product;



public interface ProductDAO {

	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int productId);
	

	
	public Product getProductById(int productId);
	
	public List<Product> listProducts();
}
