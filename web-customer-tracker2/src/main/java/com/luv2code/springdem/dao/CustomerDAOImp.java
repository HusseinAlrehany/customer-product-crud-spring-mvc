package com.luv2code.springdem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

		List<Customer> theCustomer = theQuery.getResultList();

		return theCustomer;
	}

	@Override
	public Customer getCustomerById(int customerId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, customerId);

		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomerById(int customerId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, customerId);

		currentSession.delete(customer);
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (searchName != null && searchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Customer where lower(firstName) like :theName" + " or lower(lastName) like :theName",
					Customer.class);

			theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}

		List<Customer> theCustomers = theQuery.getResultList();

		return theCustomers;

	}

	

	

}
