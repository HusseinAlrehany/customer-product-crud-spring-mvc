package com.luv2code.springdem.dao;

import java.util.List;

import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();
	
	
	public Customer getCustomerById(int customerId);
	
	
	public void saveCustomer(Customer customer);
	
	
	public void deleteCustomerById(int customerId);


	List<Customer> searchCustomer(String firstName);
	
	


}
