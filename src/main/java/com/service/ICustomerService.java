package com.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.model.Customer;

public interface ICustomerService {
	// initialize logger
	public static final Logger logger = Logger.getLogger(ICustomerService.class.getName());
	
	/**
	 *  add customer to data base
	 * @param cus
	 */
	public void addCustomer(Customer cus);
	
	/**
	 *  get customer details by using id
	 * @param ID
	 * @return
	 */
	public Customer getCustomerById(int ID);
	
	/**
	 * get all customers in database
	 * @return
	 */
	public ArrayList<Customer> getAllCustomers();
	
	/**
	 * update customer details
	 * @param ID
	 * @param cus
	 */
	public void updateCustomer(int ID , Customer cus);
	
}
