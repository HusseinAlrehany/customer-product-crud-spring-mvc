package com.luv2code.springdem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdem.entity.Customer;
import com.luv2code.springdem.entity.Product;
import com.luv2code.springdem.service.CustomerService;
import com.luv2code.springdem.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	

	@GetMapping("/listproducts")
	public String listProducts(Model theModel) {

		// GET THE PRODUCTS FROM THE SERVICE
		List<Product> products = productService.getProducts();

		// ADD PODUCTS TO THE MODEL
		theModel.addAttribute("products", products);

		// RETUEN THE LIST
		return "products-list";

	}

	@GetMapping("/productForm")
	public String showProductForm(Model theModel) {

		// CREATING A PROCUT OBJECT

		Product theProduct = new Product();

		// SET THE PRODUCT AS A MODEL

		theModel.addAttribute("products", theProduct);

		// POPULATE THE FORM

		return "product-form";

	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("products") Product theProduct) {
		
        
		productService.saveProduct(theProduct);

		return "redirect:/product/listproducts";

	}

	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam("productId") int id, Model theModel) {

		// GET THE PRODUCT FROM THE SERVICE LAYER
		Product theProduct = productService.getProductById(id);

		// SET THE PRODUCT AS A MODEL TO REPOPULATE THE FORM
		theModel.addAttribute("products", theProduct);

		// SEND IT OVER TO THE PRODUCT FORM

		return "product-form";

	}
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId")int id) {
		
		productService.deleteProductById(id);
		
		return"redirect:/product/listproducts";
	}

}
