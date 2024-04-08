package com.luv2code.springdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdem.dao.CustomerDAO;
import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		return customerDAO.getCustomerById(theId);
	}

	@Override
	@Transactional
	public void deleteCustomerById(int theId) {
		customerDAO.deleteCustomerById(theId);

	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomer(theSearchName);
	}

}
