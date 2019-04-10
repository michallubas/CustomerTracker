package com.mLubas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mLubas.dao.CustomerDAO;
import com.mLubas.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegate calls to Dao
		return customerDao.getCustomers();
	}

	/*
	@Override
	@Transactional
	public String randomName() {
		return customerDao.randomName();
	} */


	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}


	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return customerDao.getCustomer(theId);
		
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
		
	}  

}
