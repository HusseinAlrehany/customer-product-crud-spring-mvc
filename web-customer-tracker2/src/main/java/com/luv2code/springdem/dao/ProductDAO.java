package com.luv2code.springdem.dao;

import java.util.List;

import com.luv2code.springdem.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();
	
	public Product getProductById(int productId);
	
	
	public void deleteProductById(int productId);

	public void saveProduct(Product theProduct);

}
