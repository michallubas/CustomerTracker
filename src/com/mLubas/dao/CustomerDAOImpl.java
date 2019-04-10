package com.mLubas.dao;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mLubas.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO{

	
	// i need to use session factory , dao will use it to talko to data base
	// bean sessionFactory in my xml..
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers(){
		
		// get the current hibberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create querry, sort by...
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
						Customer.class);
		
		// get List of custome from query
		// return list of customer, execute query, get result list
		// execute thequery, get us a list of object from database, map it to the appropriate type 
		// and return as a list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results
		//System.out.println(customers);
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// behind the scene hibernate will check if customer exist or not 
		session.saveOrUpdate(customer);		
	}

	
	/*
	@Override
	public String randomName() {
		
		Random random = new Random();
		int randomId=random.nextInt(3)+1;
		Session session = sessionFactory.getCurrentSession();
		Customer randomCustomer= session.get(Customer.class,randomId);
		String randomName = randomCustomer.getFirstName();
		
		return randomName;
	} */

	@Override
	public Customer getCustomer(int theId) {

		
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	
	@Override
	public void deleteCustomer(int theId) {
		
		Customer customer = new Customer();
		Session session = sessionFactory.getCurrentSession();
		/* othe option to delete: customer=session.get(Customer.class,theId);
		session.delete(customer); */
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		// execute code , updates, deletes etc
		theQuery.executeUpdate();
	}  





	




}
