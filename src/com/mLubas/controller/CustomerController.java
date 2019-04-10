package com.mLubas.controller;


import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mLubas.entity.Customer;
import com.mLubas.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	// i need to inject the customer dao
	// with autowire, spring is going to scan for component thah implements CUstomerDao interface
	// so it willl find CustomerDAOImpl thanks to @Repository annotation on CustomerDAOImpl

/*@Autowired
private CustomerDAO customerDAO; now i don't need it :) */
	
	// i no loger speak with interface CustomerDAO, we switched to CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	
		// get customers from the dao
	List<Customer> theCustomers = customerService.getCustomers();
	
		// get randomName from DAO - only for tests..
	//String randomName = customerService.randomName();
		
		// add the customers to the model, name "customers", value theCustomers
	theModel.addAttribute("customers", theCustomers);
	
		// add randomName to model,
	//theModel.addAttribute("randomName", randomName);
				
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		Customer addCustomer = new Customer();
		
		model.addAttribute("customer",addCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer") 
		public String saveCustomer(
		
		@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
			
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from our service
		// second scenario: Customer theCustomer = customerService.getCustomers().get(theId);
		Customer theCustomer = customerService.getCustomers(theId);
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// whatever data we populated for attribute customer, it will be use to pre-populate each fields in jsp file: firstName, etc
		// wczeœniej lecial pusty cusotmer w /showFormForAdd, teraz leci wypelniony, w tle , Spring powie, jest obiekt, ma nie puste pola
		// spring will use getter method when form is loaded, when submit, Spring will use setter methods: from load = get, from submit=set!
		
		return "customer-form"; 
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	} 
	
		@GetMapping("/testSide")
		public String jstlTesting(Model model) {
			
			List<Customer> customers = customerService.getCustomers();
			model.addAttribute("customers",customers);
			
			return "jstl-testing";
			
		}
}

