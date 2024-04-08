package com.luv2code.springdem.service;

import java.util.List;

import com.luv2code.springdem.entity.Product;

public interface ProductService {

	List<Product> getProducts();

	public void saveProduct(Product theProduct);

	Product getProductById(int id);

	void deleteProductById(int id);

}
