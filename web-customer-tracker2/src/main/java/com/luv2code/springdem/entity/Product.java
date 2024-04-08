package com.luv2code.springdem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int productId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="customer_products",
	joinColumns=@JoinColumn(name="products_id"),
	inverseJoinColumns=@JoinColumn(name="customer_id"))
	private List<Customer> customers;


	
	public Product() {
		
		customers=new ArrayList<>();
		
	}
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	


	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	
	
}
