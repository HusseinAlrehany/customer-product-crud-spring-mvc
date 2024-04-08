package com.luv2code.springdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdem.dao.CustomerDAO;
import com.luv2code.springdem.dao.ProductDAO;
import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {

		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
	       
		   productDAO.saveProduct(theProduct);
		
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public void deleteProductById(int id) {
		productDAO.deleteProductById(id);
		
	}

}
