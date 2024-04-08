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
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		// GET THE CURRENT SESSION
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Product> theQuery = currentSession.createQuery("from Product order by price ", Product.class);

		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	public Product getProductById(int productId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Product product = currentSession.get(Product.class, productId);

		return product;
	}

	@Override
	public void deleteProductById(int productId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Product product = currentSession.get(Product.class, productId);

		currentSession.delete(product);

	}

	@Override
	public void saveProduct(Product theProduct) {

		Session currentSession = sessionFactory.getCurrentSession();
         
		
		currentSession.saveOrUpdate(theProduct);

	}

}
