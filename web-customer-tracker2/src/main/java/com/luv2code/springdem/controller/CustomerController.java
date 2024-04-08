package com.luv2code.springdem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;
import com.luv2code.springdem.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/listCustomers")
	public String listCustomers(Model theModel) {

		// GETTING THE CUSTOMERS FROM THE SERVICE
		List<Customer> customer = customerService.getCustomers();

		// ADDING THE CUSTOMERS TO THE MODEL
		theModel.addAttribute("customers", customer);

		return "customers-list";
	}

	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String searchName, Model theModel) {

		// GETTING THE CUSTOMER FROM THE SERVICE
		List<Customer> theCustomer = customerService.searchCustomers(searchName);

		// ADD THE CUSTOMER TO THE MODEL

		theModel.addAttribute("customers", theCustomer);

		return "customers-list";
	}

	@GetMapping("/customerForm")
	public String showFormForCustomer(Model theModel) {

		Customer theCustomer = new Customer();

		theModel.addAttribute("customers", theCustomer);

		return "customer-form";

	}

	@PostMapping("/addCustomer")
	public String addCustomer(@Valid @ModelAttribute("customers") Customer theCustomer
			,BindingResult result) {
		
		if(result.hasErrors()) {
			return "customer-form";
		}

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/listCustomers";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		customerService.deleteCustomerById(id);

		return "redirect:/customer/listCustomers";

	}

	@GetMapping("/updateCustomer")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {

		// GET THE CUSTOMER FROM THE SERVICE
		Customer theCustomer = customerService.getCustomerById(id);

		// SET THE CUSTOMER AS A MODEL ATTRIBUTE TO REPOPULATE THE FORM
		theModel.addAttribute("customers", theCustomer);

		// SEND IT OVER TO THE CUSTOMER FORM

		return "customer-form";
	}

}