package com.luv2code.springdem.service;

import java.util.List;

import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;

public interface CustomerService {
	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int theId);

	public void deleteCustomerById(int theId);

	public List<Customer> searchCustomers(String theSearchName);


}
