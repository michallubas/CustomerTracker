package com.mLubas.dao;

import java.util.List;

import com.mLubas.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	//public String randomName();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
} 
