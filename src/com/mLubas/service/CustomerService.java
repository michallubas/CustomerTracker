package com.mLubas.service;

import java.util.List;

import com.mLubas.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();
	
	//String randomName();
	
	public void saveCustomer (Customer customer);

	Customer getCustomers(int theId);

	void deleteCustomer(int theId);
	
}
